package workshop;

import java.util.*;

public class Workshop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberCount = 5;
        int maxNumber = 40;
        Map<Integer, Long> prizeMap = new HashMap<>();

        prizeMap.put(5, 3000000000L);
        prizeMap.put(4, 1000000000L);
        prizeMap.put(3, 500000000L);
        prizeMap.put(2, 350000000L);
        prizeMap.put(1, 150000000L);
        prizeMap.put(0, 0L);

        List<Integer> userNumbers = new ArrayList<>();
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

        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() < numberCount) {
            int number = random.nextInt(maxNumber) + 1;
            if (!winningNumbers.contains(number)) {
                winningNumbers.add(number);
            }
        }

        Collections.sort(winningNumbers);
        System.out.println("당첨 번호: " + winningNumbers);

        int matchCount = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        long prize = prizeMap.getOrDefault(matchCount, 0L);
        System.out.println("맞춘 개수: " + matchCount);
        if (matchCount >= 1) {
            System.out.println("축하합니다! " + matchCount + "개 맞춰서 " + (6 - matchCount) + "등입니다!");
            System.out.printf("당첨금: %,d원\n", prize);
        } else {
            System.out.println("아쉽게도 당첨되지 않았습니다.");
        }

        scanner.close();
    }
}
