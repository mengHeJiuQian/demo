package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)

func main() {
	response, _ := http.Get("http://www.baidu.com")
	fmt.Print(response)
	marshal, _ := json.Marshal(response)
	fmt.Println(marshal)

	//resp, _ := http.Get("http://localhost:8080/wechatmobile/api/v1/beneficiaryChg/queryLocation?policyNo=01263175")
	//data, _ := json.Marshal(resp)
	//fmt.Println()
}
