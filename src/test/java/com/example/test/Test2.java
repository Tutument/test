package com.example.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //test02();
        //test03();
        //test05();
        //test06();
        //test07();
        //test08();
        final int i = Integer.bitCount(127);
        System.out.println(i);
    }

    public static void test01(){
        String a = "a";
        String b = "b";
        String intern = a.intern();
        String c = "b";

        String b2 = new String("b");
        System.out.println(b.equals(b2));
        System.out.println(b2.hashCode());

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(intern.hashCode());
        System.out.println(c.hashCode());
    }

    public static void test02(){

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }

    public static void test03(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd:HHmmss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(Long.valueOf(5));
        String dateStr = now.format(pattern) + after.format(pattern);
        String dateStr2 =  pattern.format(now) + pattern.format(after);
        System.out.println(dateStr);
        System.out.println(dateStr2);
    }

    public static void test04(){

        List<? extends Number> list = new ArrayList<>();
        //list.add(new Integer(1));

        List<? super String > list2 = new ArrayList<>();
        list2.add(new String("1"));

        List<? super ArrayList> list3 = new ArrayList<>();
        List a = new AbstractList() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }
        };
        //list3.add(a);

    }

    public static void test05(){

        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("aj","a");
        jsonObject.put("cj","c");
        jsonObject.put("bj","b");

        jsonObject.put("fj","f");
        jsonObject.put("dj","d");
        jsonObject.put("zj","z");
        jsonObject.put("zf","z");
        jsonObject.forEach((k, v)->{

            System.out.println(k + ":" + v);
        });

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("aj","a");
        map.put("cj","c");
        map.put("bj","b");

        map.put("fj","f");
        map.put("dj","d");
        map.put("zj","z");
        map.put("zf","z");
        map.forEach((k, v)->{

            //System.out.println(k + ":" + v);
        });

        ArrayList<String> strings = new ArrayList<>();
        //strings.stream()

        //MultiValueMap<K, V> multiValueMap = CollectionUtils.toMultiValueMap(map);
        //JSONObject jsonObject1 = new JSONObject();



    }
    public static void test06(){

        Class<Test> aClass = Test.class;


        System.out.println(aClass);
        Class<?> proxyClass = Proxy.getProxyClass(Test.class.getClassLoader(), Test.class.getInterfaces());
        System.out.println(proxyClass);
    }



    public static void test07(){

        try {
            JSONObject jsonObject = JSONObject.parseObject(null);

            System.out.println(jsonObject);
        }catch (Exception e){
            String message = getMessage(e);
            e.printStackTrace();
            System.out.println(message);
        }
    }

   /* public static void test08() throws IOException {

        String png = "iVBORw0KGgoAAAANSUhEUgAAAPoAAAD6CAYAAACI7Fo9AAA3uklEQVR42u1defxd07Xfv3N/vwwIWlp92veqfR1e8ajyqqoqaGuoRydUDUUfrU6oWQ1JtIZShBhiiCHELFJjKAkZjEmQigiJREbySyQRMue+s/Y6wz7z3vvsc+65964/1kf87hn22Xt/9157Dd/F6ozVSUhIWlsYdQIJCQGdhISEgE5CQkJAJyEhIaCTkJAQ0ElISAjoJCQkBHQSEhICOgkJAT1OarX96j16fI2EhKRCwtjzZoEOD63XO0hISCokHR1PE9BJSAjoBHQSEgI6AZ2EhIBOQkJCQCchISGgt4BstNGnqO0kBPRWF8u61JYz69ts06MyberV6wt2my6RaPtf7DG9s77llhvQWBqUT31qo3pn5/cI6K0F9GucvvnQHtxv1/v27Wx4m2q1w502DU5tDyxSeN0Ku+3frUTbm12+9KWedn+OsmVafdNNNyWgtx7QQd6u9+mzWcXUuCvrBx1UywA6yEf1rq7tC1x8flLfYIMtJa890F549mm6uQDAZuyfXp9a1rkE9NYD+lp7gv6wEmo7Y8uFMZuaeKwQgW5Z5xTcT+fZ75ksBXbGJtkypd679+eaZh50du5mt3lGBC9FLp5tA3RUk4banbxHBYC+ohJ9UqsdIYzX9RnXHuJdqzap+2oCvc7Bbln9E4WxYUL7X69vscWG/H6wI/TrZ+WaKzvu2FXQLj4kBiuLbZlvyxUE9PyT+lCnXRPqG264RdMCvUePre2deCsj7WFsuNOedXx3T7u2Z8//VAZ6r15f5PYISG7SA7qaWFY/Z6yPsv99Vo5xuth+3mXK9/Xu/R+xfwfNxLL+bD9zltDeRTbgnnCOKf9maH6d0N5Ah10FJpw/Ifo3pB2MLXXa8ExO481jhtrj9sfAzGtVgY7XuxP7VSVrvQj0rq6v28/6Uqww9nRI9d3JAzosXjrn3k02+YQwVwYrAu0O+90HhP52gf2c94S+Hmpf83N7Ufhs4nPA0MnYhYob2YH8SMjY+dUGeq12rON+Mi+MjYtJoT2iAUAP7jzqK/YVwjP+nnP1v8h51vL6xht/0ijQQe1l7PLQbjtQC+hJ1mh8hzthV9v3HC/MpaMM5WSvsTeJPRVU4uHO3Pop313R/rHKlul8R+/R47+lnoPfhgY62SMIY2O8dmcdTxsKdFB7wBjk3gudVqRY1uVNBfTOzh/wXcrv31XcNabTDlAVGVvotOUehR1aDuhhkKNM4ccOU0DH+eI++7HQpuECvVtjbjwiPPdZxbPvcOHecfZ3nG2P267K4+MCHXHwT1tGZgpjHwjvnpPq/my46g6rJ3SMrGulnLP9cY6hxITUPT+6+r1LYvr4bandOPpN+wuazf5GgQ6aWbCNd/Hx3HzzPkZ3dDjb+jvYLglAH6vcN336bO49V6XNQaDPrG+1VS/tOScCnbHRdn8MyBTx/G9ZJ6VqAuReS9yhrne+aRm3BOuL2zfv5XyOL5Z1itK3gPsMbATYjvHS98kAHQAX3FnuzOFeSwc6nn3hmpExi4AZoKtbs12gT88130Sgy2p/vur+AvnRdQUMJ+D77NFjm4ae0c0YJvcSxmgC/y4TQO/q+qZ3HEC5VXtXkwE6Y7MdA9zOBHQCetU0A+yXjTb6dAPbMCY0Tqv5+T8P0AFsjH3sGbAYuy+XHzoL6D4Q4kNHCegE9EoAvcy45qhBLzxOD0vtvElAR3W92/ltqf3/exuKjEvuK7Ro1xOPLQR0AnqDjXqNBbo/GaYIhqw9tVX3Wu1XAshX2v+/r8EQ2OS+Yuw67rpKChkloBPQGxj+el5DgQ6JH/j+t2wg/G8uoGNAx5XCWC8xmmqZ1ldoTJzGJXlRJaAT0I3szseWDnSI7rOsP2m1F8ExyhmTrQPuNR2gM/b3gPtHx8Wn21fQXnQLHkZAJ6AXrQKvUgZ7XqAz9jiPke/R47+0Le2WdWrEj64HdHcSDlL6Fss6n4e05ukr93yevhAT0AnoBo1q0Lngz5URiLISw1dl70MRM55m8zhvFQYTjIF+jU9iHaB/8pMb2234dSDbyrJ+ozV5u7q+lRPo92SG0xLQCegBgbRGHVdXY2tiLVZK/UQKqNcC0YYqQIf+CZfw0cmeMwF0WHAYm5dJNEFAJ6CHJlQ/W87IEfhyuT3pP1+4QJqnyAIj286urh34MSPsJ5cFOhrw3neunagNAFNARxDOylycmwXo4LUgoBduUPuJ0M6tNYHeLyZffFv77xfy3Ud+YoE6/tUUwH5DiE0/XMEAN4Hn4afFuscBHfOnz/USJODfOvnopoGOKaRTUvuqWYCOkYSLeQhvOKaegG5INtzwM3b7FghtfUfp3Js1CMB2wtijUkkRMPHds3fSgqMDdMhdT7JMpwEdCToWON93q7d7VgHoPpnl7NTFuepAR16B8cI8OqE1gQ5+WPiYRgjS+UyKae/NCrm/6YPg+6mfTiRb9Cf1AKENC2xAfcUI0GWz11ygA+caY//yQljDu2ZVgI6ayjAeD5A0Xo0H+jonkChJFoXm3qoAO03LAJ2xNypZ/B3yh00AHYx8/mLyRP0Tn9gk5VlrnOvetyfoL4zt6CpAx4n1Lv/+pBj1vEBHBhTos9NzuyKBwMHluYPdsXpAX+XYNFRkSOsBHQxMsKpZ1i22XM9XeVnBsEsRnAOU7k+Tnj2/LNmpUzIHQSRetKzBCdf8yP59vXPNb42e0VWADjtjFo9eXqBDX+F33mIoTfUWp/3fJ6t7lc/o+imMvxfesTbTMFOMtX5g5iBgmOgMr51xBIDASYa/P5mq4pehuqsEzIAhSd1T8ag01bUM0MHFh9rQmsiu7gN9nZNVpyIrCOiNNsYBGPwJAzQ7oxrklhsoNQiwo7htDbPmoE/4Tc42AxpOusGuWkCHKD3IY5eVWu2XPOnFv3+pkShCy7rBGYeLEoD+Ju8vFYFAIAJ6g4EOTKJBtf34SgMd0iixrTMi53T3CAKTMtsy33igQ5FFOMebsYUMMgJ0/zsWBAo4kOre5EB3z3koH+dmfCka6FBfDa/7c+DvcCa2rLv44IgqO6j3HR0PR9T8RgK9s/M7XkwAVGgJElSqs6pCEkxWkUmVvAB38RG57wjoTQ50CADxn39bAyPqBkoPAliyw4Yu8AFDamfY+Acca67KWRWg4+R9y6Ocgig9CDbSEVntQQ3o4yJstgT0JgY6gmNFJeiY4oAO7LWgqssIuNyAojj4t1tD/XdFhYDucqcP5EkyVcrdh4osBPQWAjpjg4SPv6HBMfJRoEMUnF/hYy0f7KiItbamZ4pLY1wc0G/LNAQCNZTf7vEEdAJ6cUAHQ5ZIfwTBF0nXAuB03D8mVHdIHoEQ0qRKGbossKaB3tX1P7yaiFwuuwv0eV6aKwGdgF4I0Gu1o4XnTkw15qB1+I1Ca2arnNGrCHQ10oq9jUzeooDO2P0E9FYBul/8YD2PJsueKP35tWAxJqBXA+i12pHS4yELdIxFmE9AbwWg+3HN8NE3Kvh8oYTRc/zfzQb0Wu3HLQV05HlbIz0e8gEzJwl92rxAx2q/j9ntPrh9gc7YQ56BSwW0Puvpi0olexsNdAgPRV/1kJYAOi66bwrfPkQZ6HBUCx/XwGUpPlc8qlUd6BBHAXPSsv7olNL+yP73ZV4ob9sBvatrR68CiGr1U+hMCM7Ae69rCqD36bOZV2oIKZT7agEdJqupRB+cjEhAoXd//5iS1T9TArplXcxBjUlQt3gJLb7MD1FlVRPoaCj+Fq+j7rYbGIPEFNW2BLrfIYulM8vid6O19rNOLgTouGM9LpmKWPcs2PG/Tw714cv1z32utwbQNxNcfVWUWanjGQY6uPSAtcfN9IuG1P6l0tlr8K0Qri2WBWfsKRsf2ymd0SH9GdiHXend+9+d7z1AGO8mAzoGyKx3JvexWs/AXf0Zz5AHbqUidnTkORfJBh51+OiCEiyF209KOjt311LdsfzS685zTtcm6vD56mYYJQBJy9ZLOqOLgT5iKHT4WVUAOjL87Gt/yzWhsOFxnH47jeQkCeigESAj8EdCvMaa0POfaS6gM3a3R/OUv0LJOq+eeK9eXyhEdU/z7ZPV3Yx7LUzBBIsq5BNUIR8d2+aqz8u90Fxf1nHuPZliF1mqO3D7Y1mqesyx6OjmATqezeXOc2rnlzqnSSL3WvP60X1Sz/GJ7rpGAB0SkZKxMJV7j0y618A4CRqDv7tj/TuZghqVADqcSRkb7nzkUEOT9fuhVe+InBPxJgJ6g4AOhBNZZZ4bAXQslPF6DA6uKNSPblknOtd+xI8EckeMCgAdzuNuw2GCmyrUAFZjv20LYxlfigYsAb2c8lWNOqP7cxdz5Gu1Q0oJmGFsGbelyNsSGgx0PE+77rT+hifPySFLbT8COgHdKNBRG51lywe5NilVoKtuWg0FuljKF4gj1YIyPs0NFKIgLdBATxi7J9I+AnqrAz2f6IX6HpNYgaXIENjKAx0rmwx2LJVulNN3eZF7CAkMi2VdyxsqCmMzM9qymodIYliseFY/hIDe0kBf6BRllJeOjhG5N4K80pJAx6op0UKCrgovL+scv+KjAR80BLRAAAkCbUhIfT+VgE6quzHVnYCe6X98QRHU3U4k2cP2oB7HJYtAASfAwZUFOtYO/4YnLv0UBv38hYBOQG9uoOPA/DTjWR84Mc6/57HCvXp9Mff5GkGzX2WAztiI0DfPdMoVvxA4gsQFiBQLuusI6AR0M0DHyi3vBWpRYYkgjCUHa6Y5SqrR3juqZIyDwcWMrFtDHOh1aT70IsRUjjUBnYDuDO7l3DUBrKkQGVfcJDre6cBTKmt1BwMlY3Nj+vQuAnppQJ9b6DxsW6CD4Syr/pcp/jngGYsrzlcO0Id7WUfZST1zAv0pY4cgoLtAH8ery+gB/eZIZR0CehPWR8+v/qOvX5WXjrGrFSfswV7hA8v6dUO+tbFAX+EVj2gnIaBXRMDfWgavPNYsn2S/73cN+1YX6JZ1WslAf4PnWbcbyINAf0EpGYaA3sSio7qaFFCDTeUcyB/jftDw726kQH69ZZ1h1AhNQCchaTMhoJOQENAJ6CQkBHQCOgkJAZ2EhISATkJCQkAnISEhoJOQkBDQSUhICOgkJAR0AjoJCQGdgE5CQkAvBuhQrYMGjISkxYHO2LN1y/oTDVqbiGX9vV6rHZnzGTfYclEDOQyGcgpz/fufqHd27tZeQPcJGW7IxRRDUrxg5c/7pVh1kkF6i1duunfv/9BMff0OJ9dk7BGe51/+YvVH+93ztfLLt9xyA/veN536aru31xkd60Ij2MsftP6l0F6ZFGivDlsL1JQHPr98QMfy10AoAVRN+kBHRmBdSi3YFd3CDl1d3yy1/5HW/B3ORacKdtjJxSpGUOCkbYBuWRcLdDsnSd3Tt2+noXdfa793gt3hezYN0KGtsCOq7giWdZfTx3/ICXR3rK7NCfTLtMexs3NX4Tkfc4KHcsdgd/u96zlYVcAO89tv9/rcR5AmA/rvhMlzVub1m2/ex772rVxVVH1j4BfsZ33IOx0KKkDJXJn78tJP9eixXU6g13npKzyvysjtwngu01Ibg0CfqKUJ+UDvNqAJjhTmze8acFaf6Lx/nhTYYVGD6kM+d+Dv2kt1F/m3oUBj9mS5zLl+mKGF5g/Ct94vtcuAFgAlqHTe17Pnl/guZFkn5AS6vujsJCLQoaJOvjN6twH7zrENBTrQmft9Oj/zemAt9q8f3X5+dB/oqyQm+d5OXba6swv/LPf7caWdL3zvwxJAr3OyRyhKAQOoIoxd69WY0wGMCHSojAMGnixBzcX9vnu0VOaqAR0ooP32HJtxph5hX/9Vo/MWiR/XCIvNaZILw0v1bbbp0dxAB3Xasq635Q5p6ei413nP1MxrGXst1LZ5RoxpUB43WC5pVwmgmxEwkukD/X+lxyVvnbqqAb13789ygx5jD2S88yLnnbfWt9qql2H1/T7pYydjL/MKParU4pXd0S3rHOHjb7flGi6MPeP9W1ag8IFlDUm9prOzr6HVWfzmEZJAf0njm54S+ufcnDt66wEdjjaW9VspYWyK/d9LUq75a6Aslm6NvuTv6ScF9FrtQMd4d11rBczEgY+xf/BgA1l/OYJvrC2j6ltssWEJZ64bhG8eKwV0HVJ+v8xQXcsoVwTQodIrqPhVAHqPHttwt5lJrUmUzs5dCrEvpQXBMDaIlxDPY4RtmjM6WLXxeTdxEKtZeZ8ohAA/2D6xEuydbQV0DOSYkGqNL1N1r9WOsK8dZv/3J1wYO5dH1Ln/nySM3cEr9aZdAxqDfMzCZ1L7GM//43itwXRbwmI+7snfe6TWsaKyxjgwYMlazGu1n5cKdKymMk+qdnlrAh2rvDJ2S2FAh4IOOmd0tM88JqlKT9b2iMSDdHnqEQveBUbZ5PE+2gbk/Vxrinfxfp57YeC83zJAt6wLhQl3Qsa1A71JkSe2WD3i6l1Jq3srAh2lo2NEIUDv6vpWBOgw0eHvchFlj2eMy1NCGw8xatln7J92312qLIy96hiTk35/SXjH3UpVXSoLdNiV/ee+kDFosxyrdHllhMCSK6PatTbQJ8UGIxUFdLRcv2//tnPifRtv/Ekn7HRVqraFGon7nacbBnoZspRX3216oIMrzAVwGtDdFRxiqmXCG2EiqJy98u/8rQv0pG8qAuhi0AtkMqZreKc4162MTW/GTWSlF0qdpCqrCC4w0533vsFLMGcJxMCjVvQPqesxDNs16O3ROgEzjI1xnvtoyqBeyl0nMtlJcD7Cs/+VUkY+AnqxQGfs0hwRewOktEEw6kX79TAv6cZkhdyODjfUdrLk3HjXaeM9ksdZv79aKjKOsSE8ui3NwgudVavtK/m8wcKK+F0CegV2dMhEhHMpRDKCduaKH+u9NPB3V7q6dpIOVIr+dq/T/jMNu7AI6HwHlQnBFAXOYrXajxJ/h1ra4LKQeRYMKoSS+m1dWcquXh2gq4fAlgH0pFgJWfcalhv+TUy/j/aSQsLXo5vrQ+O8BgR0PmmPK9lYISP3tQ3Q9dTjxpzRIb4bsg5lgI4up4mx/AFxceWuWh+3OLgLT612jNYiQEB3IqoYgzDDaU465AB7x96xoaJitQyH7sq6ZKoCdHBRyvSJ779uHNCDlv1uCX/4xITYijmRMzgyFT2WmKwDdGV4tNuHgK57RgewmyKCaJQAYwvGIq+XOvdW7YwOBklwOyV5KKpgdUcLthzQ8Sw/n7clKudH/sbYi/xYEH99P+F4N0bJT01Al6DbMWn5DMdCyxJEBAF2CO/8OGHsX4HsNdg5qg/0lV7cNvCvQSZXR8fw2Gw4BPoiTiUFgG0E0MUEkGygdxd2tLOsvxHQTQEd8q7B6rrpppsWwNf1sv3sC5TvhcQYxh4MZZ4NdOQq4e+rbAB9v9JAt6zbInED/qCv4P0jGiXh32lkjOUDfW1i/jZ4W5BzYAqfd2EBSz744+N+ixPoiyDQ/6wJ9JU8lTpb1nhMPnLXL2pu9xrsLq56CZPMhNRqhwqT7UCNgI1vxuaai2mqMuBtJNCzB301z6/XPT8XBXQxag1V6Y94AkrUYDcu9R3I1zZWwf06zHnny3wD0j+jL+CpqFnC2BJPA5C7fkxrAL04AdX12wbZQloF6BNzGcrKAXq31w+izcA1mmUH5TzNF4pa7ccSaaSzOch1E11IdZcG+gc8mcWEiKsfJDhk5VAT0KsBdABkMN6hmxvFGHvbUeNPdfp1mbfjp9E4Q2CUywCbZkm3rJP5dTo7OQFdGejTC2H0MM//RUAvDuiHheZUt9OPNwmUWts70W1wbr1NYgyeTiV9QC7Ax7jrjQJmCOgE9BKAzthdzr1vB4AOVV/8eTZTcS4cn8oCCy5Ty7oiNzsRAZ2AzkMyk3y3yT7dBwsG+vWZ59aePb9SGtAxqGqsV/QhmqbqH8dUCjFgCul6Kbpn8P7EuRUJ6AT0UlhgTQEd/eRzpUAIrjnI8BLdc0UC3c86W80pk8JADxrgfqEFQoityE5xHUMhsAR0XdX9Ru7TVREIE1YBelfXDlzdTxPLOkMYr5sTr2PscuG6OaUAHbj38b4XY4knMNhHb0wt68pMPnUIlPK/7UQCenFAX+9wYpmQNW13RkcQTirERQl8ZkUDHSmukQ45DuigVmOF0TFOmSWV+bCKBwilX7Na+OY1yqnMPtBflyzQMdshnhgudT0sVi0C9Pd4HLYJgZJJrQP0pfycKXfPj/jZO6lfwD3lj9eNKf03TLjugVJ2dEh4gnsA0HFAx+/7JS+HjEB53WEhGhsjvjYS/7uMDNMEevFCqnslVfdp9gTdXwvoljVIGuQmiyv4dEwwptsWDnSIu8d7HuHuriSgB1NUv5hYfcdv46WlJDvhwjPFee9bXAPLEr+810ip68UKswT0ygH9Xu3a3sUk+oggPFwK6MBXVjTQgfNPLIctA3Q5TaocoAfJIYs8o6+UqvlHQC8Z6FUTSMJxk0XkCBbLATpj47kaDi49k0DPSjpqJqBDX9ZqBzVvpZZWAzrs4FBiOV5F3V7JB2xafA78tRmTcKinhophoUUAvWfPLzshrben0j3rAF2G8Repxm62F5nNDAB9vEISjRrQzcROVALoS7SI7+PJ7sc1DOgw2HFAh1I6mM/+VH3zzfvE3LeIs7yUA/SFGZNwumcRLjpgBgxsGNq6gxGgY1FFeaC779dxqbmyySaf4IZQtcUoP9CBy4GxJzNZkNsie80kM20W0NGq/c8MrnKksIbQy+DAX8ZTHMUJb57DbpbUsaNMoKO1emoMFVR+oIMrDp6fJm7UHLb30BI5//MDHbQgbPuQVH76igF9ZiqBPVbPdCfZhRlk95cK155XCtChMizSU38n1U+cZAxD3vl3uBpb1M7uv/uHuYGexLevAnQosAAGJmD01WGBzQa6qkxtGqAzdkFgkQK7ShMAfSEn9M/OGZYrJg/F7kClSeOENwl0dK/MSNzNkSjhjVB/TYsxlu3tsKYsNA52JC/Ad6cV+5MHenduoOOC/EokoSQP0MEYhm1/QvJ6N7hqVGafgzsPQnVNSNC9pnYvkmrMC82nFYntbzjQYYAhNBF8olnXqgBdpnKLSaAzdrVj5f1Owjnw/wJEGOAjT8qWQgs0BhCZrCeHBTHqPG0TFp78QB9voIDDnNgywbpAxzOru1NerQR0sF/IGQ7fqSB1uStPxebUV7pSSx6gp02Enj2/ahToQLzolmyOs6hjvvNCoZ/+IcFZt9YzmplgzsU2zI7lOo9qFXt55A9h3jQEOvz2fCKZh3xQzh95nEFcIQ1doPvVVOu8xrkK0GUr8QLYMcPwNB7FpytiCGye54Qlbg62HdAt63aeMpq1o8kCHdI4oXg9xEnDGT2NKxzlfSngWtZfAiVy8+ZKQ2Ser97tlAGWvQU/9N4RzwGwsZiIvoMouKRa9rpAB85914MjE6iEKvD6wucuuddKBDpjFwYyt/ID/QIepeSqw/Ft3kyoOhIFTnoFkveE9t6b83x+s7SxKQ3oJsNsxdBaE0BH5t/nU8cjugAeW8rcbRugg5qmSrwQlb8FziJqJA63RdqqU2hRBDpjzwnP6pswkY4Wrr9aqUQvY4NC7d1Ha5AxvdMlXji+MkBPX5jUgY6ltutSx5Mo0FdHSDYI6Fq1146uoOFihjKffBDodc9qmjyYb3sRZlDAUOVdWPBwlfCeRVrFLoDSGe+fJXn90U0JdD8aco7yPR0do0qPUmxJoMNOBoXtwLIJKpssqX6QkH8XYcW+XOsZYVE9+0LEm6xmALRFebjl8RlXhYoKnKcxobqVgkH8uIZ3tSrdNAromJJa5/EK8vdMJKC3ojEu/+A8HvrmxxMmOwT3LPcKHOZLfxTf96xSuWedogR5cw8aAXQo8OC6LlXmoA/0hwjoBHRxQp2dGt3mu8dcsDyTK1kCjwqjA++Uid9GwG3H64Cjpf2bUvdggcP5TQV06A+oCaA6L8DN6lZLka2OS0BvE6CDj9Kna/owVrWFVEL8fWxs8or6GXtfZaCjv3t8oJJq1K8+lPejqCFAaKzfx/1T+eng3rjS00DcWCbQLesyz0CrctQQcw8I6AT0BLV8RWxSB7rTcBEwVSUWwhqRcEAlI8uNxBuRuGChr36Fc93cQKEDnPy/Snn+waFKph96hShF3rqige4XfFiaGJWIKaTD7WuP4NoGLIJgM+roeMC5d3npFncCehMAHSfin2P5v+EMDROnVtvP8KSY7FV2zSovhRFn4E67L9PYCMEzjL2qxUsGYctY/mpZwnxYV+/d+7OFAR2LOizjantn5x6p2g16HtxFbULoONTdIHsPAb3yQIcIsbBP3LJOd9hD9ypgYTnJC9LJ9pnP45ll0EbZXGrGXotlfZU/1z8TMx+ezvG96UDHmPY3nGzBXSXDY/cJZHuJmZAEdAK6QvGBZVp+Z/mJMTbVF487HKjNdyiz2ICK7Y/jM8rFBsEWEV4s8mQOpgEd+3qys5PvqvidB3jeEPf5JnIJCOhtAnSoAmpaXVefOK/zIgg69wIJBgT3gA9a10uAEXUuiK5RcgMmA31sTPDPKp5ApHuuBpprN2Goq2vnBo7Xu9y2kFUmqk2Bvpafr3TCV1tdoLxwPuLIXQxM3ju5jSAvL55l3cQXHbE0ElQ8hfM1qOB5FhE0JI7kFNONJel8ItGA2NZAhzNnWayeJI2VuN06LQmGpIWATkJCQkAnISEhoJOQENAJ6CQkBHQCOgkJAZ2ATkJCQCchISGgk5CQENBJSEgI6BUUyGprZGlkEhICOo+jPiVXtZbs8E0gOhjMs8mabUJAggWknRI4zM0FSNCB9GECeukfPdLhRRtY32CDfysALKc7/TGfs9E008TUTVM1waJT9rcCD3xWscm8AtRWjD3AOQLykIQ2PdB1Mq7gnjzJLQh0t80vBjKkzAB9UIBlBWiumwHkQCDpt3utcq53vj47z37nrdqlsvTe+XvO2KNDaa2WLXek06frOcVXWwLdss7kOcZZ9EjBe/7Ga5hB2mpeoFvWJQXtin41l6J3DXMTX6wr/m4sVVZxxB3bOO8dnCsFVVawfNM7HrUU7O7FakprvL6FmvBtCPT+zr33S66OxwrVS8ZxwgR9oE/LXbww2r5jhP54Qfm8C4yvSeWdygQ61C1vzLEBxwVqxBUrb4bopPoX3LdXKZGmANeeZV3fikDXEwCGPtAnFzBZ7xXa9kOle5EHbSZX99PIDssAuix3fDFAf4qDQUbgWrGKjex9eFSoe3Xo42irzfZtP4FiK/1IBB4bt4iGKY2z4UAXubUZG8I5yNOEsbO88r9gIVZR+YsGOgJ1vvA9T9rvelhaGBsl3Lu0UP65KgM9jkZbBkAqcwF579Xfp2//2Ml53z8ktLpfCvNgpT0Pvt38QAert9/hp0pQ8OzpnSHzG+PMAl2sQmpGluemh1ID2nMEdKnj1dEO35uKzHHet0zi2iWheTApt8uTgG5okmLppCc9ZlEdg4tliaWdJ9vf+oOSgTbZqUP2hEbbB/MCCe2yozM2xjGwuWf+F225iVeNsawTFeQ0XgvAsk5OvS4vRyIB3RBIxO9gbEF9ww0/o2h1/pqRwgeNADpOVlzg8livmwnovXt/LkLsiEe3CRy08uP+X17xTAiuaVmre6sAHSq34DPHc2+AZd2teT/0w0XGtAwV8YH+pPQ9lvUnh5nXt0u08xndsv7K+wOYcOWAvrXQd+8UFk1JQDdihPuUYGl3jYZ1Xs1U5v5NN91UMOJ9wCun5G0TnO2jJZ7LkVrt521tjPOf+1uJ9g/0gmks6/LC/PmVBTqWwh3Kq3aWCXSdqpr+YL3AAYYgu40bYOTuP1nog/ONDS7WVp/JY61RTuBejjixrF8LbTg98To5+XqbA/0+7whWq+2fce18pw03tHbATBLQsexO3TF43O8Zt4oEOhQwALWrVjtU+lm9en2e+2ExvPHHoTM31Ca/QWI3f1Mw4n3R6ADLWu07O3cTduSfNDDOvvmBbllXCJgYl3gd1ClwrepF5xY0AdDRJeGujGGgw5kGJqmKoIUUnjHd+1ut9lP7/xd5xjRZY5g/0SbFTNzbnfpgfVPuP0f4/qsbGP7aj4BuLJxXnLsPprQdYkI+lk7oAU1J9jjYlEAXrZhhoKOls4iz5n2ZbcfCgh/w6+POVvA399wN10YHbnvhfRMaGhNvWXd49cjKzlxrZaCnVaWFzcGyBkiCfAc+NlChVidsuymALnZWnOoOxh886zzkhEEmC2OvBEIf066FnT59kl2SOZgYXIFhneJExKSKt7zop1rtwAYntNzhpdY2NkW2NSLjoLZbmgcC+BAYmyv1LFTxZwp4+EV7Al0/s0zf6g6qvVvVM20HRIPYFOf7zhEm6MXCd1/XUJCja+0pAnqi/WIPHvWoIlj19YTE3xm7y5ZzpJ6FR8AgzlSJLNoK6FA90xTQAeAAdJnzFUwUXBRg5z7M+YYPnTbMM55Bp2edd8fg7w0HOvQtsADJCI6D2/Yzpe+Da2WBDp6YRrgp02UcAT159R9gBOiQTAMGws7O3RUm8VDnna9xtwv+ewl3RzU6Dz0I9PMMpuwepBTG64/LYm4olZPFwn0zFO6bIQ10yCaDuQlSRq5821rdTQEdBzgf0DGSaTafxCr3wWQRdx9MV/xBJSaBb0cwB3QIEcUEjhnSCRmtnL1GQC8J6ODiCoZq6gGdsUdsuVmZ8gjPwZOEd89Vjocvw7UW5x1QFWD+YexfATVTpr+aDejQV0VxJII9x2SUXNsAHSLO8L5Vwvl4suJisTfPmVftZAhpZWxsTH+9aoyuqWfPr3AWE8u6Rln8uIK61v3R570aExb7q5YDOs7dd+1vO86whvVjb36aAntbAB0H9SUvSKZIhpl4kI8W+gjSGM8IEAvUakcZMma9UEGjkSsf13v1+oIU0FXYXhoPdPf7xhiUWcJz3zBCFd0kQD8yF9DdJBM3jrssoHd27iXs5Cs4U0jfvp28wAOCfb0Q5vtkJO1Rh1oYJi3s7hBaKyvQNuybG5XuU5Us9d0dI7i2+YC+2ulHE7JGeO4SI8eDJgD6itxJLTCBXVdW0ZxxIskj7GJuDHtX184JFMf1wKDC2QwMWWWdzzHzbqWntjeeU745gS6TeanzTeGkLgJ6Jo2wz2xaNNAxG22pxxEGHPRJ/nbLOj6kquGCBJFVZbDBwrHB758/ENArBvQ2MsblAzoYz1zVymXwKAroQD3N2N2e0Q/458GtBkEy+P/Hx/phkWVkZkx/rue8caiOf7WQUklQXMIfu+0aaPk/h4BOQNcDOp4/ZzjPvrlQhhmgdvYJAN8OkC8g0N0+GpholMK89g9S+heYb+/hAv3gSh5Vn7HnvWOD6RRZtcl9HgGdgK4HdJ+++COeKVYE0DHm/XrhG06q9+mzWWgROCzQR2n+c8xvH61k0YZIvfxAH9tgXz4BvS2BjiQQaUBH2qb0jB83aGOEcSopsHBD3rb/jgcSK7SKQJetvVWr7Wdf/7JgmQ/LGru/rs0V4NLV9Q3heY/nXvDaGehYdOICI4IutjYBOgZe1HmMuA7QfRL8mREA5gE6uMbQgPWKRzgB70oH7WGCFXVHxSPBgQ7hZHgX/5OBneNsoS8Pz3FsOYAvyFCksX2BPkWpWEd6IY9p7Qf08CDIAh3pneq8Vpspckikh3rAS04BVhqZSpyMPeaFvcrufLCju9eCdgIqvWVd6XHT5ffx784Nfa7hUNeNAxRffoLIy9qkFUFX42yFwghLNO+bTap7swMdeNrSWFtUgA6qMST6Y5z6Mh6ppJr476ticgCFM7y7S8Sd50V7gz7Qv11IBBwUcsgPdJUii93CfW9qFVkkoJcAdIgGi+ss14INaq8K0CEqDH3YqxMZYlSAjsUJ3uCVLXv02DbgEgP+c+jALPF3naWS178TmLywm5s2fsERBDwA7vFDtOKrCGNXx4D9NA2j4MtkjGtloIvVVINAjx/0LKBb1iDnWRca4XUHyqckYggotOD7u9emiF+BJf06V9YFXGpF+bcxo+7FiJdAVqBfgllq63hJIh1/v0t73NFxH1+ECOhtAHQxNj0Z6M9Gdjo0XGG1lDSCAFPuNVgEIHMpLUZdligwaaDB+1DVHGeIpDOlefj85ndog6KxxrjnOTe7CYEjZ4sCfS73P2+wwZah89pIngQSJn6Iq20FQSgQqAKUzVllZsvMXqvVfuZlqQFjbZGTt0xBcsN1ni0hr3ut+YFejLTQGX0PvusFB312JJotm73lMmk/dZlAxxUaI8+KnrzlxqUP9uqFwYTPtxge4MULwHxoRqADRzs8M0mQccdvZ5pg/TYsm90yQI9nJ+l2Bn036cUC339Vrkotzc5sWpZgEYxFTtDObwwSLciPebWA/nJmDj3Oa7ldGuP+7zVSg6+yQPcH/S3uowarbtYzcWG4TJq4ryygi6yzYrmm7MXhfue+qcqUVeVQQz/nAOQqQ1rP2YExbxagQ8wA2IXAViO3gckBvYhCHpUDug/CIc7u8T0+AeIqdGKY6wgeAJHFXtIIoENBCTe4Btoqf1+3MwFvKbR9LiGE2m7+fY9RBY5MZibhSO1AoGYhh1QBehrhZtOWZIoGirgRbQdE+N6AHSaaYjmDV17Vm1jFAR3LMS1y2n2x4gJRDtAt61yeCw+12V1DaLqquqXDBzfNmFqJgHtZOzmnXYCOxua3OFeBjvuyUkDHQofoHhP/jmWI73D8tGd5EWsdHSO0XDplAN2fgAuV0z/LAjpoGZheu8ZZYEekeiwgvx6uBS3LnPX+P7UCZdoJ6AjyGUp1ASsNdJfAEWiY4sI+fQCcaEhVnFzgoLrRbdcrnuu39yioTBi6ZOMBgqmxD0Zi39GdBtGKdxp2Px7uFW3IG1xSBNBBWwSNDNiJ8smgANORioBhLsqqu29zAt33N49LPM8CSaTozqgq0MH6r1sjq1Y7WMh0K6+KC6iDkBEnjmVHx71eGzAx52njlUpwIssHEzViR4cjo8jK2tExXEMeEfp1eG6xrKFSx63KAR1LFS1OTdjAkMvXnXet5YahqgFdTBbRqXrZKKAHVek3AiG4aFR8r5BiBW4GncqkLRvoWJLpj7yNuvn/JoxxTW91r9UOde6/RWJgxbDLZ7TcT0UBHRN0XFLIvHWsZzeskgtoISJrji/D7d/+3WB/fc/b4UzEhasA3Q+Xbh6re1MD3S+uMEWK+wx54HzW1CRjHLjjIPMtzjpcBNCDRSJGa1lGsdihq7FMrEAs+4CYMZ5hA3QfQ88/xdF8jioE6LADwxxwxf0djVv3lwp0UdNrS6BjAss6XppWXt0bKgxS/5RJ6pZfWsrFsq6w5XKBIH+yoUHcRSig+Gyqz5yxKzhtU612DJ944plXpF5WNeIVIRhafEEMndWc3Ds7PnsqdxnlOfenAR01BrEgwjJnLnwcKna5VwmLZr/2BTr6zV/htarVFoefS1UkheejsWdOQnsnGwD5bk7p3tXc7QGUz9nJIC8JbZjA3WggQavqcQ0HerC/F4T6boRSOmm03/bOTWElq7pjhOJ9zhhF50EZpZDFduZNAGo6oKN1eoxW8IXLBCuTSw0ukiCZg5kSwZb1ay8oBnZolTBSLMmURO28tpAwyHwL2p5GAQJEHmCANQegaZmhqGJ5aNHukGfB0gF6Ho9R0wEd65Kt0A6jBAZWiOiSn6h7hQgdPtZ+N57xHnBU2snaKzSe2z6OWYDOqhTIfUaaiwNqvC7QMRlklXKN+WQA3SvtxoSqriKTrkyVVwK6JtDRcPWatntMv7Ov9aLVdBhLIawVqaWm8/xpcIXl3yn3CPXhfUpx8eWnp16UG+gQDyGbgpxN2LmNcnw/ug/X5eLDJ6BLAB1CWssGObo4NrPb+IhWZRN0x8zlOxqkEer6fcMC7kHGRnmGRR2XXJmC7Z3Cg2l0VV4AWpYto9jF6sbctoE8QE+zK7W0H70ZBPygLrmAeWPXwdo0ySTNIVA1COYPzKO2DZghISEhoJOQkBDQSUhICOgkJCSNAToGi3SnSpZ/EyzoGE0m3vc+t27K+lTBn4vW0Hmh59zOCRn0fM1+m2STUqDqC7Yj2AfgDoRAFZn3on/40dAzXuHP1YkXwAQdtx1nSN0D1NyY6tod8y3nRKi7k59xTsz9A3m9OP2Ekones7K48nEcX82cozLEHujSDd/7EB/zZHyclvnuoIysJtDjgkRUan6LIbDxMi1ARZUctPF66nPA36vmdgqWJ5JxwWFI7KyUdqy227F/xsLZP6M/Rimxt2ABxqXCWAww8B11Hkbb1fX1FNKNr3v87vGynGcvqrvTXg3Ftu+W4QXZPzfnOjL3rEq5f1ZimW3RFScnL7Qe0BGg8yTa8mZGG+6QeMYi6eSNuLROGaD7BJLpC1dSNhyCQ6b44cmSIN/Vid2vKwFd7jsQ7MnPeEri/g+U0ncZi2bgFQ10DLleJvGMua0L9FrtiNA9K73sMlHiyh37ak34vStiF4845lhUlb/mZLUF48vxOWGA9EtV8YDPO2knywI6EEvE7eDYJ+FvOUYBYMtjF4u0XR2jFW8SMr3kgZ78HUtjE0niQpc7O/smPGNZzP3nSx6JvhZZtGSA3tHxYOieZbFzNFnDui7mW1bG9kUcuQgkecW9Ly7zzmXkrSDQj8qVWGJZ94TeOZifdyAvXSyFm5YZJRYMEHOse/b8sv3vQSE6pYe1jxBZQLesE0L3TOCTECh9GRsW6qdrEoA+P1Tk8Hxuv4CFAUJ9xWck5e4jyN9J0QYGKH7HDG+RxUVgTOaYB8smg4zl9yKl94Oh+y/MnCeQKCXWQFcD+sOB61UTjKLvHMbHFDMdJ4S+5UTF+T8o0tfAClQ5oKPBKLhjYtTQb6XCEoNAnxlQaUUygTSgW9adoev84gpYNOLtwGqeVHIoS8XKAjrw4wUn4J4hlpcFgWNEfKKOuAOPj6FzFvv6lBTCi7oxoIcNiJivv0YB6GsDBrMgq5Ac0EXOAhWg49FQ1CLe5jRS7hyVyZEIvu+1QDRlOAtQBeiwGYU1URmQNwjoz2c8Y2qmIQ3O7zAxgJOts/O7jjEqvCOt5/TR6VRSqPaH467DueFJO2EQ6B9Gdq5soE8NqNvR359OPROGNZNwXXK0nK/JBEgQ6OucfPnFiqr7o452MT82/FNGiwMDFvwGqj3YRnBcR8csPOdkAKJv6hxLAzousFnz/IHEgiFRzWREjIHxKd5nMl6I4HwYH+qHk6rpXkPiwcVSz5Gls4X44fhnvCbBGRdfvTO86ibTVR1hP+sJzloD3+2SKegAPQ6E4WNOFtDjzuBZ73BJN+E7QGq1/Zz7pisZ49It+ItDY3uEBO31txLGdSHPIkw+l28d8Bi4/HuyQAfbkNxcnyEJ9DS5ULofa7UfRaz2KnHzpQK9q+sbCp0wLifQFyQWvjMF9CTWlGYDenzb8gM9SJapVgo4GegfeYtRPD/9qFhDpizQLesC6TkKKn0+oIMxbkfJ8ZgYeveZ1Q2YiQIdJsFddqNPtf87Sdlokg50rHIZxzpCQC8W6BBTAKmYUQvxCmluwGSgJ39r1KNT53YKsRqMOtDn8aMCFHGAgKzgb/MVgD4jwS18t8RuflDoHvViF6UCHc6CsAq6JPSw4gcn173KQIdyRwAwEL8qp9ie7QjoJQOdsWsT5sdQJYIId1xxR/4w1YiFC8u6iMoO7K9Yoy/I4AN9FzeuPXt+hZOIYpGEmwNUZcAkFAyCkQH6Yt4GcMUiH8KzEZtUNkiHhzSUo6sN9Gy/539LAV00xkV/u10J6HGVTlHDKBfoMAHiOfXkgQ7vj1JeLSwN6ACSsCtMZOvNyuUHlRyNcWcl+JaTgR5eFOXsQOqAsaxLFIC+hgcgib+jV2eMNNCxWOeKwPU6pB2lAt2ybhCunciZZtIGKw7oae61OFdPNtCDLgqwhELscPlArweMKy7dlprV/erQ7z9TdkvpAh2jwWbGBjPJVKxJc6/FUW4VBfQst2LQJTpf+TvwGROkgQ5UWcE23VT9pJYg0OsB9xdaS+coAh0DZtJipeOAHnb3MHZPLNG+65uW5XBTBbplXRQaxEHCxD0kwlYan6zRHYgkcxctDDR5PmT42bkwoKMbqR7j4jxMcqc8LxLt5arNSAs+oXSgw5laDLeFY2fweDA/5ij5+cTviLcpTVXKYwhrbRUFevjstooXM4CzUDT8dEos+aBlDYt57wjHp/1BxAUR54oBP320KMFUJ+BmZSgyboQyV7k80H8faoPrw348khBhWVclACwc/fUxj6JjbEnk2SoFH1WAblnHJ6jr1zoBUUEBP7ecUfU5Z1wnZYaOQvXXuHehDAy1awj/e7hiLH73mphEmot5pB6GSYvP+WtC360NPeND3oewG0ftCLdnjMPowHkfNKfKAx1CVaMx5kmuiysTrLE7xcakx8v9KR34isT9qyIGQ5NAx3bMlWjHssQBrtX+T7I/hyga1OSBnnQuT27LeQnPWSD5jLlK36JmdT9RwTW2Q25felI+RryGMb158tEZu1niORPrG2306ZRnPCDxjOdSiztgKaisZ4xU9BurAz3OJRSV6zP69PWM+5enVqnND/SpRoAe1XDi5N3E9E4TQEfL+CyJb+ifkSA0TOIZpyqF04Jm0TRAxxK0A2IDKSAYAnaeLEZUfMalCamAy7malVW1wz/Xdceo8R/yMEVVwgYdoIPbBd2C3THfsoSfzbPagfHZk2P81qsdogV1woZGAN0n0JifkKE4M5WwwQTQfc3zoQTNcT5vYxbVNdaWGx5zhKo7RBpnS9Flqy4MlXOvQUYQGJxEUR1ErJYZfIZskH+46ov4DJWzbLjWm/icsFchux3Bb1GlBu7RY9vA/WCp1qeg/qEwLttmXLtvpO1pklV0ATwf4Xsg2Er3W6Cmufgs2Ww0UM3D7VCNT8dMwuAzdOeEziJHnHEkJMQZR0AnISGgE9BJSAjo1LEkJAR0EhKSZgc6hF3CQ0lISKojkoQvTDmOmISEpOmEgE5CQkAnISEhoJOQkBDQSUhICOgkJCQEdBISEgI6CQkJAZ2EhMSX/wcOvRlN9M+4igAAAABJRU5ErkJggg==";
        byte[] pngBytes = Base64Helper.decodeBytes(png.getBytes());
        String origin = "XsCHJ0099C93BEE6DEDD4CE4B377F195D3B27D28";
        byte[] originBytes = origin.getBytes();
        ByteBuffer bbc = ByteBuffer.allocate(originBytes.length);
        bbc.put(originBytes , 0 ,originBytes.length);
        byte[] dzym = PngUtil.wirteFileToPng(pngBytes, bbc.array());
        System.out.println("结果："+ ByteArrayUtil.bytesToHexString(dzym));
        String encodeBytes = Base64Helper.encodeBytes(dzym);
        System.out.println(encodeBytes);

    }*/


    /**
     * 打印异常信息
     */
    public static String getMessage(Exception e) {
        String swStr = null;
        try (
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr = sw.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            //log.error(ex.getMessage());
        }
        return swStr;
    }

}
