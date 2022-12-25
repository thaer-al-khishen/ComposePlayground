package com.example.composeplayground.youtube.part_9_constraint_layouts

import androidx.compose.ui.layout.Measurable
import androidx.constraintlayout.compose.*

fun ConstraintSetScope.createSmartRefFor(id: String): Pair<ConstraintSetScope, ConstrainedLayoutReference> {
    return Pair(this, createRefFor(id))
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.clearConstraints() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            clearConstraints()
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.height(dimension: Dimension) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            height = dimension
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.width(dimension: Dimension) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            width = dimension
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.topToTopOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            top.linkTo(targetReference.top)
        }
    }
}

fun ConstrainScope.topToTopOf(targetReference: ConstrainedLayoutReference) {
    this.top.linkTo(targetReference.top)
}

fun ConstrainScope.topToTopOfParent() {
    this.top.linkTo(parent.top)
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.topToTopOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            top.linkTo(parent.top)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.topToBottomOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            top.linkTo(targetReference.bottom)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.topToBottomOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            top.linkTo(parent.bottom)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.bottomToTopOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            bottom.linkTo(targetReference.top)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.bottomToTopOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            bottom.linkTo(parent.top)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.bottomToBottomOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            bottom.linkTo(targetReference.bottom)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.bottomToBottomOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            bottom.linkTo(parent.bottom)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.startToStartOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            start.linkTo(targetReference.start)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.startToStartOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            start.linkTo(parent.start)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.startToEndOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            start.linkTo(targetReference.end)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.startToEndOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            start.linkTo(parent.end)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.endToStartOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            end.linkTo(targetReference.start)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.endToStartOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            end.linkTo(parent.start)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.endToEndOf(targetReference: ConstrainedLayoutReference) {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            end.linkTo(targetReference.end)
        }
    }
}

fun Pair<ConstraintSetScope, ConstrainedLayoutReference>.endToEndOfParent() {
    val constraintSetScope = this.first
    val constraintLayoutReference = this.second
    with(constraintSetScope) {
        constrain(constraintLayoutReference) {
            end.linkTo(parent.end)
        }
    }
}
