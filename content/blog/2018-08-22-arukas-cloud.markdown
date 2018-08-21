---
layout: post
title: "Arukas Cloud"
date: "2018-08-22 00:31"
author: 'u-ryo'
categories: [docker, sakura, arukas]
comments: true
published: true
---
[Sakura](https://www.sakura.ad.jp/)がやっているからそのreverse spellingだという[Arukas](https://arukas.io/)、
docker hostingをやっていて、
credit card登録は強制されますが1 containerなら無料だというので、
専用SSH machine作って[JHipster](https://jhipster.tech/)の開発/buildに使おうと企みました。
無料枠では[Docker Hub](https://hub.docker.com/)にあるものしか使えないとはいえ、
SSH machine用docker imageなんて色々あります。
