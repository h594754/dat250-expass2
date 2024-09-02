package no.hvl.dat250.expass1.domains;

import java.time.Instant;

public class Polls {

    public static class User {
        private String username;
        private String email;

        public User() {}

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class Poll {
        private String question;
        private Instant publishedAt;
        private Instant validUntil;

        public Poll() {}

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public Instant getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(Instant publishedAt) {
            this.publishedAt = publishedAt;
        }

        public Instant getValidUntil() {
            return validUntil;
        }

        public void setValidUntil(Instant validUntil) {
            this.validUntil = validUntil;
        }
    }

    public static class Vote {
        private Instant publishedAt;

        public Vote() {}

        public Instant getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(Instant publishedAt) {
            this.publishedAt = publishedAt;
        }
    }

    public static class VoteOption {
        private String caption;
        private int presentationOrder;

        public VoteOption() {}

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public int getPresentationOrder() {
            return presentationOrder;
        }

        public void setPresentationOrder(int presentationOrder) {
            this.presentationOrder = presentationOrder;
        }
    }

}
