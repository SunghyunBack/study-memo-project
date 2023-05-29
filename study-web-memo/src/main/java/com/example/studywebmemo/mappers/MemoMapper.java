package com.example.studywebmemo.mappers;

import com.example.studywebmemo.entities.MemoEntity;
import com.example.studywebmemo.models.PagingModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemoMapper {
    int insert(MemoEntity memoEntity);

    MemoEntity[] selectAll();

    int selectCount(@Param(value="searchCriterion") String searchCriterion,
                    @Param(value="searchQuery") String searchQuery);

//    int selectAllCount();

    MemoEntity[] selectByPage(@Param(value="pagingModel")PagingModel pagingModel,
                              @Param(value="searchCriterion") String searchCriterion,
                              @Param(value="searchQuery") String searchQuery);

    MemoEntity selectByIndex(@Param(value="index") int index);


    int deleteByIndex(@Param(value="index") int index);

    int updateByText(MemoEntity memoEntity);

}

