---
layout: post
title: "Testing code in Javadoc using Groovy"
date: "2016-03-17 02:40"
author: 'u-ryo'
categories: [test, groovy, javadoc, java]
comments: true
published: true
---
`groovy.util.JavadocAssertionTestSuite`を使ってJavadocにtesting codeを書けるんだそう。
[うさぎ組 プロダクトコードのJavaDocにテストコードを書く方法](http://kyon-mm.bitbucket.org/blog/html/2013/05/29/use_javadocassertiontestsuite.html)より。

```
class Sample {

    /**
     * add prefix 'sample'.
     * <pre class="groovyTestCase">
     *    def sample = new org.kyon_mm.Sample()
     *    assert 'sample foo' == sample.prefixSample("foo")
     * </pre>
     */
    String prefixSample(aaa){
        return "sample $aaa"
    }

}
```

と書いて、

```
import junit.framework.Test
import junit.framework.TestCase
import junit.framework.TestSuite

class ReferenceTests extends TestCase {
    static Test suite()  {
        def suite = new TestSuite()
        suite.addTest( JavadocAssertionTestSuite.suite( 'src/main' ) )
        suite
    }
}
```

と書けば、gradleでもtestしてくれるそう。
こんなのがあったなんて。