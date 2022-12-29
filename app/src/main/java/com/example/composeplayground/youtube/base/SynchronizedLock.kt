package com.example.composeplayground.youtube.base

class SynchronizedLock {
    private var isLocked = false

    fun lockWithCondition(condition: Boolean, action: () -> Unit) {
        if (condition && !isLocked) {
            action.invoke()
            isLocked = true
        }
    }

    fun releaseLock() {
        isLocked = false
    }
}
