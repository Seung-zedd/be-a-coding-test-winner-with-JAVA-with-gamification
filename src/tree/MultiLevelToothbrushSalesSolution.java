package tree;

import java.util.*;

public class MultiLevelToothbrushSalesSolution {
    /*
     * [문제 27] 다단계 칫솔 판매 (Multi-level Toothbrush Sales)
     * 
     * [미션]
     * 민호는 다단계 조직을 통해 칫솔을 판매하여 수익을 창출합니다.
     * 모든 판매원은 칫솔 한 개당 100원의 이익을 얻으며, 이익의 10%를 자신을 참여시킨 추천인에게 배분합니다.
     * 배분하고 남은 90%는 자신이 가집니다.
     * 
     * [제한 조건]
     * 1. 10%를 계산할 때 원 단위에서 절사(버림)합니다.
     * 2. 배분할 금액이 1원 미만(0원)이면 더 이상 배분하지 않고 자신이 100%를 가집니다.
     * 3. 추천인이 없는 경우("-") 센터로 이익이 배분됩니다.
     * 
     * [입출력]
     * - enroll: 판매원 이름 배열 (최대 10,000명)
     * - referral: 추천인 이름 배열 (enroll과 순서 동일, "-"는 센터)
     * - seller: 판매한 사람 이름 배열 (최대 100,000개)
     * - amount: 판매 개수 배열 (seller와 순서 동일)
     * - return: enroll 순서대로 각 판매원의 총 이익 배열
     */
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 구현부는 용사님의 몫입니다.
        return new int[enroll.length];
    }
}
