package com.synchrony.codechallenge.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgurResponse {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("link")
        private String link;

        @JsonProperty("deletehash")
        private String deleteHash;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getDeleteHash() {
            return deleteHash;
        }

        public void setDeleteHash(String deleteHash) {
            this.deleteHash = deleteHash;
        }
    }
}
