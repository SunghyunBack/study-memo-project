package com.example.studywebmemo.entities;

import java.util.Date;
import java.util.Objects;

public class MemoEntity {
    private int index;
    private Date datetime;
    private String nickname;
    private String text;

    public int getIndex() {
        return index;
    }

    public MemoEntity setIndex(int index) {
        this.index = index;
        return this;
    }

    public Date getDatetime() {
        return datetime;
    }

    public MemoEntity setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public MemoEntity setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getText() {
        return text;
    }

    public MemoEntity setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoEntity that = (MemoEntity) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

// 둘다 동일 한가의 여부,  1. 리스트 같은것들            2. hash나 map같은경우
// 굳이 적는 이유는 다른사람과 프로젝트 할때 유용하게 하기 위해서 사용하는것이다. 딱히 학원에서의 배움에서는 연결해서 사용하지는 않는다.

}
