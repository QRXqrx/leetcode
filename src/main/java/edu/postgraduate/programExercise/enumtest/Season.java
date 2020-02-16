package edu.postgraduate.programExercise.enumtest;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-15
 */
public enum  Season implements Showable{

    // 对象是public static finald的
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不会唱");
        }
    },
    WINTER("冬天", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("一剪梅");
        }
    };

    // 属性是private final的
    private final String SeasonName;
    private final String SeasonDesc;

    private Season(String seasonName, String seasonDesc) {
        SeasonName = seasonName;
        SeasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return SeasonName;
    }

    public String getSeasonDesc() {
        return SeasonDesc;
    }

/*    @Override
    public void show() {
        System.out.println(getSeasonDesc());
    }*/
}
