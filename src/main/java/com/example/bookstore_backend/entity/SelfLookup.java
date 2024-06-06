package com.example.bookstore_backend.entity;

import java.math.BigDecimal;
import java.util.List;

public class SelfLookup {
    public class Tuple {
        private String bookName;
        private int num;
        private String isbn;

        public String getBookName() {
            return bookName;
        }

        public int getNum() {
            return num;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }

    List<Tuple> bookInfo;
    int totalNum;
    BigDecimal totalMoney;

    public List<Tuple> getBookInfo() {
        return bookInfo;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setBookInfo(List<Tuple> bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}
