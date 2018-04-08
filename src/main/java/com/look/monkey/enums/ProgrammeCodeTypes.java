package com.look.monkey.enums;

/**
 * Created by happy on 2017/6/17.
 * 视听节目编码类型
 */
public enum ProgrammeCodeTypes {
    movie(10),//电影
    internetMovie(20),//互联网电影
    TVPlay(30),//电视剧
    TVProgram(40),//电视节目
    internetVideoProgram(50),//互联网视听节目
    liveProgram(60),//直播节目
    other(70),//其它
    unknown(-1);//未知，系统返回用，不作为参数。
    private int value;

    ProgrammeCodeTypes(int value) {
        this.value = value;
    }

    public static ProgrammeCodeTypes getProgrammeCodeType(int value) {
        for (ProgrammeCodeTypes codeTypes : ProgrammeCodeTypes.values()) {
            if (codeTypes.getValue()==value) {
                return codeTypes;
            }
        }
        return  ProgrammeCodeTypes.unknown;
    }

    public int getValue() {
        return value;
    }
}
