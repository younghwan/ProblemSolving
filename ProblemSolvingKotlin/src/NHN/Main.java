package NHN;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {

        char[] participant = new char[numOfAllPlayers - 1];
        int[] ans = new int[numOfAllPlayers];
        ans[0]++;
        for (int i = 0; i < participant.length; i++) {
            participant[i] = (char) ((char) 66 + i);
        }

        int targetPos = 0;
        int taggerPos = 0;
        char tagger = 'A';

        for (int game = 0; game < numOfGames; game++) {

            targetPos = targetPos + numOfMovesPerGame[game];

            if (targetPos < 0) {
                targetPos = (participant.length + targetPos);
            }
            else if (targetPos >= participant.length) {
                targetPos = targetPos % participant.length;
            }

            Boolean isContain = false;

            for (int k = 0; k < numOfQuickPlayers; k++) {
                if (namesOfQuickPlayers[k] == participant[targetPos]) isContain = true;
            }

            if (isContain) {
                ans[(tagger - 65)]++;
            } else {
                ans[(participant[targetPos] - 65)]++;
                char tmp = participant[targetPos];
                participant[targetPos] = tagger;
                tagger = tmp;
                taggerPos = targetPos;
            }
        }


        for (int i = 0; i < participant.length; i++) {
            System.out.println(participant[i] + " " + ans[(participant[i] - 65)]);
        }
        System.out.println(tagger + " " + ans[(tagger - 65)]);
    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < inputData.numOfGames; i++) {
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}