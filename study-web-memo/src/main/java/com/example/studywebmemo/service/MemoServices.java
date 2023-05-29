package com.example.studywebmemo.service;

import com.example.studywebmemo.entities.MemoEntity;
import com.example.studywebmemo.mappers.MemoMapper;
import com.example.studywebmemo.models.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemoServices {
    public static final int PAGE_COUNT = 10;

    private final MemoMapper memoMapper;

    @Autowired
    public MemoServices(MemoMapper memoMapper) {
        this.memoMapper = memoMapper;
    }

    public boolean deleteByIndex(int index) {
        this.memoMapper.deleteByIndex(index);
        return this.memoMapper.deleteByIndex(index) > 0;
    }

    public MemoEntity[] getAll() {
        return this.memoMapper.selectAll();
    }

    public int getCount(String searchCriterion, String searchQuery) {
        return this.memoMapper.selectCount(searchCriterion, searchQuery);
    }

    public MemoEntity[] getByPage(PagingModel pagingModel, String searchCriterion, String searchQuery) {
        MemoEntity[] memoEntities = this.memoMapper.selectByPage(pagingModel, searchCriterion, searchQuery);
        return memoEntities;
    }

    public boolean modify(MemoEntity memoEntity) {
        if (memoEntity.getIndex() < 1) {
            return false;
        }
        MemoEntity oldMemoEntity = this.memoMapper.selectByIndex(memoEntity.getIndex());
        if (oldMemoEntity == null) {
            return false;
        }
        memoEntity.setDatetime(oldMemoEntity.getDatetime())
                .setNickname(oldMemoEntity.getNickname());
        return this.memoMapper.updateByText(memoEntity) > 0;
    }


    public boolean write(MemoEntity memoEntity) {
        if (memoEntity.getNickname() == null ||
                memoEntity.getText() == null ||
                memoEntity.getText().length() < 1 ||
                !memoEntity.getNickname().matches("^([가-힣]{2,10})$")) {
            System.out.println("정규식 실패");
            return false;
        }
        memoEntity.setDatetime(new Date());
        return this.memoMapper.insert(memoEntity) > 0;
    }
}