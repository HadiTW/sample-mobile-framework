package utils;

import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class BlockchainExplorerVerifier {

    public static List<BlockchainExplorerResponse> getVerifyBlockchainExplorerResponse(String address) {

        return RestAssured
                .given()
                .body("{\"search\":\"" + address + "\"}")
                .when()
                .post("https://www.blockchain.com/explorer/search")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getList(".", BlockchainExplorerResponse.class);
    }

    @Data
    @AllArgsConstructor
    public static class BlockchainExplorerResponse {
        private String chain;
        private String type;
        private String search;
    }

}
