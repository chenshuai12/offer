import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class CityTree {
    // 输出的时候前面空格数
    private int rank;
    private String cityNo;
    private String cityName;
    private List<CityTree> childCity;

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<CityTree> getChildCity() {
        return childCity;
    }

    public void setChildCity(List<CityTree> childCity) {
        this.childCity = childCity;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        for (int i = 0; i < rank; i++) {
            System.out.print(" ");
        }
        System.out.println("-" + cityNo + ":" + cityName);
        if (Objects.nonNull(childCity)) {
            childCity.stream().forEach(CityTree::toString);
        }
        return "ok";
    }

    /**
     * 循环查找 层层遍历名字
     * @param lv1
     * @param lv2
     * @param lv3
     * @return
     */
    boolean isValid(String lv1, String lv2, String lv3) {
        if (Objects.isNull(lv1)) {
            return false;
        }
        boolean flag = true;
        CityTree cityTree = isValid(this, lv1);
        if (Objects.isNull(cityTree)) {
            flag = false;
        } else {
            if (Objects.nonNull(lv2) && lv2 != "") {
                CityTree cityTree2 = isValid(cityTree, lv2);
                if (Objects.isNull(cityTree2)) {
                    flag = false;
                } else {
                    if (Objects.nonNull(lv3) && lv3 != "") {
                        CityTree cityTree3 = isValid(cityTree2, lv3);
                        if (Objects.isNull(cityTree3)) {
                            flag = false;
                        }
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 如果在当前层找到则返回
     * @param cityTreeParent
     * @param cityName
     * @return
     */
    CityTree isValid(CityTree cityTreeParent, String cityName) {
        CityTree cityTree = null;
        if (cityTreeParent.getCityName().equals(cityName)) {
            cityTree = this;
        } else {
            for (int i = 0; i < cityTreeParent.getChildCity().size(); i++) {
                if (cityTreeParent.getChildCity().get(i).getCityName().equals(cityName)) {
                    cityTree = cityTreeParent.getChildCity().get(i);
                }
            }
        }
        return cityTree;
    }
}

public class CityOperation {
    public static void main(String[] args) {
        HashMap<String, String> cityMap = new HashMap();
        HashMap<String, String> parentMap = new HashMap<>();
        String cityPath = "D:\\work\\area.txt";
        File file = new File(cityPath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String string;
            while (((string = bufferedReader.readLine()) != null)) {
                // 找出所有的编号名称键值对，以及父子级关系
                String pre = string.substring(0, string.indexOf("-"));
                String next = string.substring(string.indexOf("-") + 1, string.length());
                cityMap.put(pre.substring(0, pre.indexOf(":")), pre.substring(pre.indexOf(":") + 1));
                cityMap.put(next.substring(0, next.indexOf(":")), next.substring(next.indexOf(":") + 1));
                if (parentMap.containsKey(pre.substring(0, pre.indexOf(":")))) {
                    parentMap.computeIfPresent(pre.substring(0, pre.indexOf(":")), (k, v) -> {
                        return new StringBuilder(parentMap.get(pre.substring(0, pre.indexOf(":"))))
                                .append(",")
                                .append(next.substring(0, next.indexOf(":"))).toString();
                    });
                } else {
                    parentMap.put(pre.substring(0, pre.indexOf(":")), next.substring(0, next.indexOf(":")));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CityTree cityTree = new CityTree();
        cityTree.setRank(0);
        cityTree.setCityNo("1");
        cityTree.setCityName("中国");
        cityTree.setChildCity(null);
        // 找出二级
        // 找出所有key
        // 找出所有value，value中不存在key的就是二级
        Set<String> keySet = new HashMap<>(cityMap).keySet();
        Set<String> valueSet = new HashSet<>();
        parentMap.values().forEach(v -> {
            valueSet.addAll(Arrays.asList(v.split(",")).stream().collect(Collectors.toSet()));
        });
        keySet.removeAll(valueSet);
        // 加入二级以及递归加入更下层子节点
        List<CityTree> cityTreeSec = new ArrayList<>();
        keySet.stream().forEach(v -> {
            CityTree cityTreeTemp = new CityTree();
            int rank = 1;
            cityTreeTemp.setCityNo(v);
            cityTreeTemp.setRank(rank);
            cityTreeTemp.setCityName(cityMap.get(v));
            cityTreeTemp.setChildCity(combChild(cityTreeTemp, cityMap, parentMap, parentMap.get(v), rank + 1));
            cityTreeSec.add(cityTreeTemp);
        });
        cityTree.setChildCity(cityTreeSec);
        cityTree.toString();
        System.out.println(cityTree.isValid("浙江省", "杭州市", null));
    }

    private static List<CityTree> combChild(CityTree cityTree, HashMap<String, String> cityMap, HashMap<String, String> parentMap, String cityNos, int rank) {
        List<CityTree> cityTreeList = new ArrayList<>();
        Arrays.asList(cityNos.split(",")).forEach(v -> {
            CityTree cityTreeTemp = new CityTree();
            cityTreeTemp.setRank(rank);
            cityTreeTemp.setCityNo(v);
            cityTreeTemp.setCityName(cityMap.get(v));
            // 部分没有第四层
            if (Objects.nonNull(parentMap.get(v))){
                cityTreeTemp.setChildCity(combChild(cityTreeTemp, cityMap, parentMap, parentMap.get(v), rank + 1));
            }
            cityTreeList.add(cityTreeTemp);
        });
        return cityTreeList;
    }
}
