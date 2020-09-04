package Programmers.Kakao.ColumnAndBeam

class Solution {
    lateinit var pillars: Array<BooleanArray>
    lateinit var beams: Array<BooleanArray>

    companion object {
        const val PILLAR = 0
        const val BEAM = 1
        const val DESTRUCT = 0
        const val CONSTRUCT = 1
    }

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var structureCount = 0
        pillars = Array(n + 3) { BooleanArray(n + 3) }
        beams = Array(n + 3) { BooleanArray(n + 3) }
        for (frame in build_frame) {
            val x = frame[0] + 1
            val y = frame[1] + 1
            val structureType = frame[2]
            val commandType = frame[3]
            if (commandType == CONSTRUCT) {
                if (structureType == PILLAR && canConstructPillar(x, y)) {
                    pillars[x][y] = true
                    structureCount++
                }
                if (structureType == BEAM && canConstructBeam(x, y)) {
                    beams[x][y] = true
                    structureCount++
                }
            } else if (commandType == DESTRUCT) {
                if (structureType == PILLAR) {
                    pillars[x][y] = false
                } else if (structureType == BEAM) {
                    beams[x][y] = false
                }
                if (canDestruct(x, y, structureType, n)) {
                    structureCount--
                    continue
                }
                if (structureType == PILLAR) {
                    pillars[x][y] = true
                } else if (structureType == BEAM) {
                    beams[x][y] = true
                }
            }
        }
        var index = 0
        val answer = Array(structureCount) { IntArray(3) }
        for (i in 1..n + 1) {
            for (j in 1..n + 1) {
                if (pillars[i][j]) answer[index++] = intArrayOf(i - 1, j - 1, PILLAR)
                if (beams[i][j]) answer[index++] = intArrayOf(i - 1, j - 1, BEAM)
            }
        }
        return answer
    }

    private fun canConstructPillar(x: Int, y: Int): Boolean {
        return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y]
    }

    private fun canConstructBeam(x: Int, y: Int): Boolean {
        return pillars[x][y - 1] || pillars[x + 1][y - 1] || beams[x - 1][y] && beams[x + 1][y]
    }

    private fun canDestruct(x: Int, y: Int, structureType: Int, n: Int): Boolean {
        for (i in 1..n + 1) {
            for (j in 1..n + 1) {
                if (pillars[i][j] && !canConstructPillar(i, j)) {
                    return false
                }
                if (beams[i][j] && !canConstructBeam(i, j)) {
                    return false
                }
            }
        }
        return true
    }

}