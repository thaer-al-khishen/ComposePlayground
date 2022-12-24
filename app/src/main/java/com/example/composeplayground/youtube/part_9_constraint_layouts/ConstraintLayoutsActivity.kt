package com.example.composeplayground.youtube.part_9_constraint_layouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.ComposableLambda
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.example.composeplayground.youtube.base.BaseComposeActivity
import com.example.composeplayground.youtube.base.*

class ConstraintLayoutsActivity : BaseComposeActivity() {

    private lateinit var constraintSetScope: ConstraintSetScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenbox")
                val redBox = createSmartRefFor("redBox")

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                redBox.apply {
                    height(Dimension.value(200.dp))
                    width(Dimension.fillToConstraints)
                    topToBottomOf(greenBox)
                    startToEndOf(greenBox)
                    endToEndOfParent()
                }

            }

            ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox")
                )
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redBox")
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {

}
