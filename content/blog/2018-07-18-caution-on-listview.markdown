---
layout: post
title: "Caution on ListView"
date: "2018-07-18 14:46"
author: 'u-ryo'
categories: [android, listview]
comments: true
published: true
---
今時`ListView`なんてあんまり使わないと思いますが、
`ListView`のviewの使い回しでbugがあったのでメモ。

`public View getView(int position, View convertView, ViewGroup parent)`
の`convertView`を使い回すわけですが、
`null`の時と`not null`の時の扱いが微妙に違うんですね。
具体的には、
`null`の時だけ`setOnItemSelectedListener`を設定して、
その`OnItemSelectedListener`が表示される初回だけ
`onItemSelected`が発動することを利用してobjectの
設定の一部をしているから、
`not null`の時にはその経路を通らず、
objectの一部が`null`のままで次に進むと`NullPointerException`に
なるという。
だからこのbugの発現条件は、
「初回表示時のリストの数が画面を2つ以上超える」時、
というわかりにくい、後からでは見つけにくいものになっています。
`OnItemSelectedListener`で設定しているのも悪いし、
`convertView`が`null`の時と`null`でない時の処理に
きちんと心を砕かなかったから、
こういうことになるんですね。

まーでもこんなlevelのbugはまだいぃ方ですけどねー
このsoftwareについては。
色々アホなのはホントやる気無くします。
