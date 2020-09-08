package main

import (
	"crypto/md5"
	"fmt"
	"regexp"
)

func main() {
	var href1 = `<a href="https://blog.csdn.net/gopain/article/details/17185979" target="_blank""`

	csdnUrlRe := `href="https://blog.csdn.net/.*?"`
	compile := regexp.MustCompile(csdnUrlRe)
	allSubmatch := compile.FindAllStringSubmatch(href1, -1)

	for i, submatch := range allSubmatch {
		fmt.Println(i)
		fmt.Println(submatch)
	}

	str2md5("yang.哈哈哈哈哈哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或liu")
}

func str2md5(str string) {
	byteArrar := []byte(str)
	sum := md5.Sum(byteArrar)
	sprintf := fmt.Sprintf("%x", sum) //将[]byte转成16进制
	fmt.Print(sprintf)
	fmt.Print(sum)
}