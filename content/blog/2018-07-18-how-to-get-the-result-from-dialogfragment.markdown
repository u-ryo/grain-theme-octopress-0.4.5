---
layout: post
title: "How to get the result from DialogFragment"
date: "2018-07-18 16:30"
author: 'u-ryo'
categories: [android, dialog, dialogfragment]
comments: true
published: true
---
`DialogFragment`をnewしてdialogを表示させ、
そこでのbutton tapによって、元のActivity上で処理をさせたい時、
どうやってfeedbackしたら良いのかなと。
呼び出し元は`Fragment`ではなく`Activity`なので、
[Fragmentで呼び出し元に結果を伝える](https://tech.mokelab.com/android/Fragment/result.html)等にあるように`setTargetFragment()`を使えないんですよね。

結局、`DialogFragment`側に`setCallback(Callback callback)`と
Functional Interfaceとして`Callback`を定義して、
button押したら`callback.call();`とし、
呼び出し元の`Activity`側で`new SomeDialogFragment().setCallback(() -> someMethod())`としてやりたいことを`someMethod()`に込めました。
ちょっと面倒ですけどこのようにcallback駆使するしか無いのかなぁと。
