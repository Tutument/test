package com.example.test.myaop.sourcecode;

public class SimpleProvider implements IProvider {
    @Override
    public Object getData(String json) {
        //解析json 拿到数据
        return parseJson(json);
    }

    public String parseJson(String string){
        return string;
    }
}
