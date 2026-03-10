package demoQA.testData;

import java.util.List;

public class SelectMenuData {

    private String selectValue;
    private String selectOne;
    private String oldStyle;
    private List<String> multiSelect;
    private List<String> cars;

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    public String getSelectOne() {
        return selectOne;
    }

    public void setSelectOne(String selectOne) {
        this.selectOne = selectOne;
    }

    public String getOldStyle() {
        return oldStyle;
    }

    public void setOldStyle(String oldStyle) {
        this.oldStyle = oldStyle;
    }

    public List<String> getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(List<String> multiSelect) {
        this.multiSelect = multiSelect;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
