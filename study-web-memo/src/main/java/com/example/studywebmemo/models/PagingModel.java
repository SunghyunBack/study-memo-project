package com.example.studywebmemo.models;

public class PagingModel {
    public final int pageCount; // 페이지당 표시할 게시글 개수
    public final int totalCount; // 전체 게시글 개수
    public final int requestPage; // 요청한 페이지 번호
    public final int minPage;  //조회 가능한 최소 페이지 번호
    public final int maxPage;  // 조회 가능한 최대 페이지 번호
    public final int dispalyStartPage; // 표시할 시작 페이지
    public final int dispalyEndPage; // 표시할 끝 페이지
    public final int offset;


    public PagingModel(int pageCount, int totalCount, int requestPage) {
        this.pageCount = pageCount; //10
        this.totalCount = totalCount; //34
        this.requestPage = Math.max(requestPage, 1); //혹시라도 요청한 페이지가 0일때 자동으로 해결해줌
        this.minPage = 1;
        this.maxPage = totalCount / pageCount + (totalCount % pageCount == 0 ? 0 : 1); // 조회 가능한 최소 페이지 번호
        this.dispalyStartPage = (requestPage - 1) / 10 * 10 + 1;
        this.dispalyEndPage = Math.min(this.maxPage, (requestPage - 1) / 10 * 10 + 10);
        this.offset = (requestPage - 1) * pageCount; // 벌충하다
    }
}
