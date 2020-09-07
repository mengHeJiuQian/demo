package main

import (
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
}