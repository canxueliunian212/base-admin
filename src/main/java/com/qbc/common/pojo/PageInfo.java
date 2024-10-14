package com.qbc.common.pojo;

import com.qbc.util.CopyUtil;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassNme PageInfo
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/14 12:06
 * @Version 1.0
 **/
@Data
public class PageInfo<M> {

    private int page;//現在のページナンバー
    private int pageSize;//ページサイズ
    private String sidx;//ソート項目
    private String sord;//ソート順序

    private List<M> rows;//ページング結果
    private int records;// 記録数
    private int total;//　総ページ数

    public static <M> PageInfo<M> of(Page page,  Class<M> entityModelClass) {
        int records = (int)  page.getTotalElements();
        int pageSize = page.getSize();
        int total = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;

        PageInfo<M> pageInfo = new PageInfo<>();
        pageInfo.setPage(page.getNumber() + 1); //現在のページ
        pageInfo.setPageSize(pageSize);//ページサイズ

        String sortString = page.getSort().toString();
        if (!"UNSORTED".equals(sortString)) {
            String[] split = sortString.split(":");
            pageInfo.setSidx(split[0].trim());//　ソート項目
            pageInfo.setSord(split[1].trim().toLowerCase());//ソート順序
        }
        pageInfo.setRows(CopyUtil.copyList(page.getContent(), entityModelClass));//分页结果
        pageInfo.setRecords(records);//总记录数
        pageInfo.setTotal(total);//总页数

        return pageInfo;
    }

}
