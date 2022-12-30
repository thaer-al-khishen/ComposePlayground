package com.example.composeplayground.youtube.base

class SynchronizedLock {
    private var isLocked = false

    fun lockWithCondition(condition: Boolean?, action: () -> Unit) {

        condition?.doWhenNotNull {
            if (condition == true && !isLocked) {
                action.invoke()
                isLocked = true
            }
        }.doWhenNull {
            if (!isLocked) {
                action.invoke()
                isLocked = true
            }
        }

    }

    fun releaseLock() {
        isLocked = false
    }
}

fun Boolean?.doWhenNull(action: () -> Unit): Boolean? {
    if (this == null) {
        action.invoke()
        return null
    } else return this
}

fun Boolean?.doWhenNotNull(action: () -> Unit): Boolean? {
    if (this != null) {
        action.invoke()
        return this
    } else return null
}
