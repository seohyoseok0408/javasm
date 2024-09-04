package workshop;

import java.util.*;

class UserInputHandler {
    private Scanner scanner; // 사용자 입력을 처리하기 위한 Scanner 객체

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> getUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        int maxNumber = 40;
        int numberCount = 5;

        System.out.println("1부터 40까지의 숫자 중 5개의 번호를 입력하세요.");
        while (userNumbers.size() < numberCount) {
            System.out.print("번호를 입력하세요 (" + (userNumbers.size() + 1) + "/" + numberCount + "): ");
            int number = scanner.nextInt();
            if (number < 1 || number > maxNumber) {
                System.out.println("잘못된 번호입니다. 1부터 40 사이의 숫자를 입력하세요.");
            } else if (userNumbers.contains(number)) {
                System.out.println("이미 입력한 번호입니다. 다른 번호를 입력하세요.");
            } else {
                userNumbers.add(number);
            }
        }

        Collections.sort(userNumbers);
        System.out.println("입력한 번호: " + userNumbers);
        return userNumbers;
    }

    public void close() {
        scanner.close(); // Scanner 자원을 해제합니다.
    }
}

class LottoNumberGenerator {
    private Random random; // 난수 생성을 위한 Random 객체

    public LottoNumberGenerator() {
        this.random = new Random();
    }

    public List<Integer> generateWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        int maxNumber = 40;
        int numberCount = 5;

        while (winningNumbers.size() < numberCount) {
            int number = random.nextInt(maxNumber) + 1;
            if (!winningNumbers.contains(number)) {
                winningNumbers.add(number);
            }
        }

        Collections.sort(winningNumbers);
        System.out.println("당첨 번호: " + winningNumbers);
        return winningNumbers;
    }
}

class LottoPrizeManager {
    private Map<Integer, Long> prizeMap; // 맞춘 개수에 따른 상금을 매핑하는 Map 객체

    public LottoPrizeManager() {
        prizeMap = new HashMap<>();
        prizeMap.put(5, 3000000000L);
        prizeMap.put(4, 1000000000L);
        prizeMap.put(3, 500000000L);
        prizeMap.put(2, 350000000L);
        prizeMap.put(1, 150000000L);
        prizeMap.put(0, 0L);
    }

    public long getPrize(int matchCount) {
        return prizeMap.getOrDefault(matchCount, 0L); // 맞춘 개수에 따른 상금을 반환
    }
}

class LottoGame {
    private UserInputHandler userInputHandler; // 사용자 입력 처리 객체
    private LottoNumberGenerator numberGenerator; // 당첨 번호 생성 객체
    private LottoPrizeManager prizeManager; // 상금 계산 객체

    public LottoGame() {
        this.userInputHandler = new UserInputHandler();
        this.numberGenerator = new LottoNumberGenerator();
        this.prizeManager = new LottoPrizeManager();
    }

    public void play() {
        List<Integer> userNumbers = userInputHandler.getUserNumbers(); // 사용자로부터 번호 입력 받음
        List<Integer> winningNumbers = numberGenerator.generateWinningNumbers(); // 당첨 번호 생성
        int matchCount = countMatches(userNumbers, winningNumbers); // 맞춘 개수 계산
        displayResults(matchCount); // 결과 출력
        userInputHandler.close(); // Scanner 자원 해제
    }

    private int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount; // 사용자 번호와 당첨 번호 비교하여 맞춘 개수 반환
    }

    private void displayResults(int matchCount) {
        long prizeAmount = prizeManager.getPrize(matchCount); // 맞춘 개수에 따른 상금 계산
        System.out.println("맞춘 개수: " + matchCount);
        if (matchCount >= 1) {
            System.out.println("축하합니다! " + matchCount + "개 맞춰서 " + (6 - matchCount) + "등입니다!");
            System.out.printf("당첨금: %,d원\n", prizeAmount);
        } else {
            System.out.println("아쉽게도 당첨되지 않았습니다.");
        }
    }
}

public class Workshop1 {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(); // LottoGame 객체 생성
        game.play(); // 게임 실행
    }
}
