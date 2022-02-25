package umb.fpv.ki.demo;

    public class Borrowing {
        private String borrowingId;
        public String bookId;
        public String userId;

        public String getBorrowingId() {
            return borrowingId;
        }

        public void setBorrowingId(String borrowingId) {
            this.borrowingId = borrowingId;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
