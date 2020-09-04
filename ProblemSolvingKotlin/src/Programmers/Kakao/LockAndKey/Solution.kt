package Programmers.Kakao.LockAndKey

class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val len = lock.size
        //3배 확장 후 중앙으로 옮기기
        val copyLock = Array(len * 3) { IntArray(len * 3) }
        for (i in 0 until len) {
            for (j in 0 until len) {
                copyLock[i + len][j + len] = lock[i][j]
            }
        }
        dfs(key, copyLock, 0)
        return isOk
    }

    fun dfs(key: Array<IntArray>, lock: Array<IntArray>, cnt: Int) {
        check(key, lock, 0, 0)
        if (isOk) return
        if (cnt >= 4) return
        val temp = rotate(key)
        dfs(temp, lock, cnt + 1)
    }

    fun check(key: Array<IntArray>, lock: Array<IntArray>, x: Int, y: Int) {
        var x = x
        var y = y
        if (isOk) return
        if (y + key.size > lock.size) {
            y = 0
            x++
        }
        if (x + key.size > lock.size) return
        val copyLock = Array(lock.size) { IntArray(lock.size) }
        for (i in lock.indices) {
            copyLock[i] = lock[i].clone()
        }
        var isFail = false
        loop@ for (i in key.indices) {
            for (j in key.indices) {
                if (key[i][j] == 1) {
                    if (copyLock[i + x][j + y] == 1) {
                        isFail = true
                        break@loop
                    }
                    copyLock[i + x][j + y] = key[i][j]
                }
            }
        }
        if (!isFail) {
            loop@ for (i in 0 until lock.size / 3) {
                for (j in 0 until lock.size / 3) {
                    if (copyLock[i + lock.size / 3][j + lock.size / 3] != 1) {
                        isFail = true
                        break@loop
                    }
                }
            }
        }
        if (!isFail) {
            isOk = true
        }
        check(key, lock, x, y + 1)
    }

    fun rotate(key: Array<IntArray>): Array<IntArray> { //회전
        val len = key.size
        val temp = Array(len) { IntArray(len) }
        for (i in 0 until len) {
            for (j in 0 until len) {
                temp[i][j] = key[len - j - 1][i]
            }
        }
        return temp
    }

    companion object {
        var isOk = false
    }

}
