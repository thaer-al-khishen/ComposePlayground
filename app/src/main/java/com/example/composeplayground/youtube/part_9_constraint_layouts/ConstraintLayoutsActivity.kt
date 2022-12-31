package com.example.composeplayground.youtube.part_9_constraint_layouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.example.composeplayground.utils.base.BaseComposeActivity

class ConstraintLayoutsActivity : BaseComposeActivity() {

    private lateinit var constraintSetScope: ConstraintSetScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val constraints = ConstraintSet {
//                val greenBox = createRefFor("greenbox")
                val greenBox = createSmartRefFor("greenbox")
                val redBox = createSmartRefFor("redBox")

//                constrain(greenBox) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }

                greenBox.apply {
                    height(Dimension.value(100.dp))
                    width(Dimension.value(100.dp))
                    topToTopOfParent()
                    startToStartOfParent()
                }

                redBox.apply {
                    height(Dimension.value(200.dp))
                    width(Dimension.fillToConstraints)
                    topToBottomOf(greenBox.second)
                    startToEndOf(greenBox.second)
                    endToEndOfParent()
                }

            }

//            ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
//                Box(
//                    modifier = Modifier
//                        .background(Color.Green)
//                        .layoutId("greenbox")
//                )
//                Box(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .layoutId("redBox")
//                )
//            }

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (greenbox, redBox) = createRefs()
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .constrainAs(greenbox) {
                            start.linkTo(parent.start)
//                            top.linkTo(parent.top)
                            topToTopOfParent()
                            height = Dimension.value(100.dp)
                            width = Dimension.value(100.dp)
                        }
                )
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .constrainAs(redBox) {
                            start.linkTo(greenbox.end)
                            end.linkTo(parent.end)
                            top.linkTo(greenbox.bottom)
                            height = Dimension.value(100.dp)
                            width = Dimension.fillToConstraints
                        }
                )
            }

        }
    }
}


@Composable
fun ConstraintLayoutView() {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {

}
