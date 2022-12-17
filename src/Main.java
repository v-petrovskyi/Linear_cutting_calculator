import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1380);
        list.add(6700);
        list.add(1560);
        list.add(1710);
        list.add(1820);
        list.add(1880);
        list.add(1930);
        list.add(2000);
        list.add(2050);
        list.add(2100);
        list.add(2140);
        list.add(2150);
        list.add(2200);
        /*
1380	22
1520	25
1560	12
1710	14
1820	18
1880	18
1930	20
2000	10
2050	12
2100	14
2140	16
2150	18
2200	20
         */
        int count = 0;
        for (Integer integer : list) {
            count += integer;
        }
        System.out.println(count);
        List<Result> resultList = calculate(list);
        int result = 0;
        for (Result result1 : resultList) {
            result += result1.getTotal();
        }
        System.out.println(result);
        System.out.println(resultList);
    }

    private static List<Result> calculate(ArrayList<Integer> list) {
        Integer max = 5600;
        list.sort(Comparator.reverseOrder());
        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(0, ""));
        while (!list.isEmpty()) {
            Integer last = list.get(0);
            innerLoop:
            for (Result result : resultList) {
                if (result.getTotal() + list.get(0) <= max) {
                    result.setTotal(result.getTotal() + list.get(0));
                    if (result.getResult().equals("")) {
                        result.setResult("" + list.get(0));
                    } else {
                        result.setResult(result.getResult() + " + " + list.get(0));
                    }
                    list.remove(0);
                    break innerLoop;
                }
            }
            if (list.isEmpty()) break;
            if (last != list.get(0)) continue;
            resultList.add(new Result(list.get(0), list.get(0).toString()));
            list.remove(0);
        }
        System.out.println(list);
        return resultList;
    }
}

class Result {
    private int total;
    private String result;

    public Result() {
    }

    public Result(int total, String result) {
        this.total = total;
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "total=" + total +
                ", result='" + result + '\'' +
                '}';
    }
}