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

[Docker Hubを使ってGitHubにあるDockerfileからimageを自動生成する](https://simple-it-life.com/2016/03/27/dockerhub/)

[Docker コンテナの動作に必要な設定を起動時に渡す](https://blog.amedama.jp/entry/2018/01/30/230221)

[Arukas.ioを使ってWEBページを公開する](https://qiita.com/ProjectEuropa/items/3909bd51454fcf4ef16d)
[arukas cloudとDockerでお手軽に開発環境をゲットする #Arukas](https://blog.stormcat.io/post/entry/arukas-development/)

[uryooo/docker_alpine_sshd](https://hub.docker.com/r/uryooo/docker_alpine_sshd/builds/)

[Nginxによるリバースプロキシの設定方法](https://qiita.com/schwarz471/items/9b44adfbec006eab60b0)
