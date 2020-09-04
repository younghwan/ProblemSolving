package Programmers.Kakao.LockAndKey

class Solution2 {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var minX = lock[0].size - 1//홈의 최소 X
        var minY = lock.size - 1//홈의 최소 Y
        var maxX = 0//홈의 최대 X
        var maxY = 0//홈의 최대 Y

        lock.forEachIndexed { indexY, row ->
            row.forEachIndexed { indexX, value ->
                //홈의 최소 최대 x, y index를 구함
                if (value == 0) {
                    if (minX > indexX) {
                        minX = indexX
                    }
                    if (minY > indexY) {
                        minY = indexY
                    }
                    if (maxX < indexX) {
                        maxX = indexX
                    }
                    if (maxY < indexY) {
                        maxY = indexY
                    }
                }
            }
        }

        if (key.size <= maxY - minY || key[0].size <= maxX - minX) {
            //lock의 홈 사이의 거리가 키보다 크면 실패
            return false
        }

        var tempKey = key
        for (i in 0..3) { //90도방향으로 돌려가면서 체크
            if (keyCheck(tempKey, lock, minX, minY, maxX, maxY)) {
                return true
            }
            tempKey = rotate(tempKey)
        }

        return false
    }

    //키가 맞는지 체크
    fun keyCheck(key: Array<IntArray>, lock: Array<IntArray>, minX: Int, minY: Int, maxX: Int, maxY: Int): Boolean {
        for (y in maxY + 1 - key.size..minY) {
            root@ for (x in maxX + 1 - key.size..minX) {
                // key의 x, y 좌표
                for (i in Math.max(0, y)..Math.min(lock.size - 1, Math.max(maxY, y + key.size - 1))) {
                    for (j in Math.max(0, x)..Math.min(lock.size - 1, Math.max(maxX, x + key.size - 1))) {
                        // key의 x, y 좌표에 따라 겹처지는 부분만 체크
                        if (lock[i][j] == 0) {   // lock : 홈
                            if (key[i - y][j - x] == 0) { //key : 홈 이면 실패
                                continue@root
                            }
                        } else {    //lock : 돌기
                            if (key[i - y][j - x] == 1) {//key : 돌기 이면 실패
                                continue@root
                            }
                        }
                    }
                }
                return true
            }
        }
        return false
    }

    //정사각형 시계방향 90도 회전
    fun rotate(array: Array<IntArray>): Array<IntArray> {
        val tempArray = Array<IntArray>(array.size) { IntArray(array.size) }
        val maxIndex = array.size - 1
        for (y in 0 until array.size) {
            for (x in 0 until array.size) {
                tempArray[y][x] = array[maxIndex - x][y]
            }
        }
        return tempArray
    }
}