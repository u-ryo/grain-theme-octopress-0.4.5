import com.sysgears.octopress.deploy.GHPagesDeployer
import com.sysgears.octopress.mapping.ResourceMapper
import com.sysgears.octopress.taglibs.OctopressTagLib

/*
 * Grain configuration.
 */

// Resource mapper and tag libs.
resource_mapper = new ResourceMapper(site).map
tag_libs = [OctopressTagLib]
non_script_files = [/(?i).*\.(js)$/]

features {
    highlight = 'pygments' // 'none', 'pygments'
    markdown = 'txtmark'   // 'txtmark', 'pegdown'
}

environments {
    dev {
        log.info 'Development environment is used'
        url = "http://localhost:${jetty_port}"
        show_unpublished = true
    }
    prod {
        log.info 'Production environment is used'
        url = 'http://u-ryo.github.io/' // the site URL, for instance http://example.com
        show_unpublished = false
        features {
            minify_xml = true
            minify_html = true
            minify_js = true
            minify_css = false
        }
    }
    cmd {
        features {
            highlight = 'none'
            compass = 'none'
        }
    }
}

python {
    interpreter = 'jython' // 'auto', 'python', 'jython'
    //cmd_candidates = ['python2', 'python', 'python2.7']
    //setup_tools = '2.1'
}

ruby {
    interpreter = 'jruby'   // 'auto', 'ruby', 'jruby'
    //cmd_candidates = ['ruby', 'ruby1.8.7', 'ruby1.9.3', 'user.home/.rvm/bin/ruby']
    //ruby_gems = '2.2.2'
}

// Deployment settings.
s3_bucket = 'www.example.com'
s3_deploy_cmd = "s3cmd sync --acl-public --reduced-redundancy ${destination_dir}/ s3://${s3_bucket}/"

rsync_ssh_user = 'user@example.com'
rsync_ssh_port = '22'
rsync_document_root = '~/public_html/'
rsync_deploy_cmd = "rsync -avze 'ssh -p ${rsync_ssh_port}' --delete ${destination_dir} ${rsync_ssh_user}:${rsync_document_root}"

gh_pages_url = 'git@github.com:u-ryo/u-ryo.github.io.git' // path to GitHub repository in format git@github.com:{username}/{repo}.git
github_pages_deploy_cmd = new GHPagesDeployer(site).deploy

deploy = github_pages_deploy_cmd

/*
 * Site configuration.
 */

// General settings.
title = 'u-ryo\'s blog' // blog name for the header, title and RSS feed
subtitle = 'various information for coding...' // blog brief description for the header
author = 'u-ryo'                 // author name for Copyright, Metadata and RSS feed
meta_description = 'ICT, Java, Web, etc.'               // blog description for Metadata

// Blog and Archive.
posts_per_blog_page = 5             // the number of posts to display per blog page
posts_per_archive_page = 10         // the number of posts to display per archive page
disqus {
    short_name = 'uryooo'                 // the unique identifier assigned to a Disqus (http://disqus.com/) forum
}

// RSS feed.
rss {
    feed = 'atom.xml'               // url to blog RSS feed
    email = ''                      // email address for the RSS feed
    post_count = 20                 // the number of posts in the RSS feed
}

// Site Search.
enable_site_search = true           // defines whether to enable site search

// Subscription by email.
subscribe_url = ''                  // url to subscribe by email (service integration required)

// Google Analytics.
google_analytics_tracking_id = 'UA-70134374-1'   // google analytics tracking code, for details visit: http://www.google.com/analytics/

// Sharing.
sharing {
    // Button for sharing of posts and pages on Twitter.
    twitter {
        share_button {
            enabled = true
            lang = 'en'
        }
    }
    // Button for sharing of posts and pages on Facebook.
    facebook {
        share_button {
            enabled = true
            lang = 'en_US'          // locale code e.g. 'en_US', 'en_GB', etc.
        }
    }
    // Button for sharing of posts and pages on Google plus one.
    googleplus_one {
        share_button {
            enabled = true
            size = 'medium'         // one of 'small', 'medium', 'standard', 'tall'
        }
    }
}

// Sidebar modules that should be included by default.
default_asides = ['asides/recent_posts.html', 'asides/bitbucket.html', 'asides/github.html', 'asides/tweets.html', 'asides/delicious.html',
        'asides/pinboard.html', 'asides/about.html', 'asides/facebook.html', 'asides/twitter.html',
        'asides/instagram.html', 'asides/google_plus.html']

asides {

    // Recent posts.
    recent_posts {
        count = 5
    }

    // Recent Delicious bookmarks.
    delicious {
        user = ''                   // Delicious (https://delicious.com/) username
        count = 5                   // the number of bookmarks to show
    }

    // Recent Pinboard bookmarks.
    pinboard {
        user = ''                   // Pinboard (http://pinboard.in/) username
        count = 5                   // the number of bookmarks to show
    }

    // BitBucket repositories.
    bitbucket {
        user = ''                   // BitBucket (https://bitbucket.org/) username
        show_profile_link = true    // whether to show link to BitBucket profile
    }

    // GitHub repositories.
    github {
        user = 'u-ryo'           // GitHub (https://github.com/) username
        show_profile_link = true    // whether to show link to GitHub profile
        skip_forks = true
        count = 10                  // the number of repositories to show
    }

    // The latest tweets.
    tweets {
        user = ''           // Twitter (https://twitter.com/) username
        count = 2                   // the number of tweets to display
        //consumer_key = ''         // to get consumer key and secret go to https://dev.twitter.com/apps and create a new application
        //consumer_secret = ''
        //access_token = ''
        //secret_token = ''
        follow_button {
            size = 'large'          // 'large' or 'medium'
            lang = 'en'             // one of 'en', 'fr', 'de', 'it', 'es', etc.
            show_name = true        // defines whether or not to show username
            show_count = true       // defines whether or not to show the number of followers
        }
    }

    // Links to social networks:
    google_plus {
        user = '' // Google plus (https://plus.google.com/) user id
    }
    twitter {
        user = ''           // Twitter (https://twitter.com/) username
    }
    facebook {
        user = ''           // Facebook (https://www.facebook.com/) username
    }
    instagram {
        user = ''                   // Instagram (http://instagram.com/) username
    }

    // Blog owner description.
    about_author = 'A ~~Java~~ Ruby programmer in Tokyo.'
}

commands = [
'create-post': { String postTitle ->
    def date = new Date()
    def fileDate = date.format("yyyy-MM-dd", TimeZone.getTimeZone('JST'))
    def filename = fileDate + "-" + postTitle.encodeAsSlug() + ".markdown"
    def blogDir = new File(content_dir + "/blog/")
    if (!blogDir.exists()) {
        blogDir.mkdirs()
    }
    def file = new File(blogDir, filename)

    file.exists() || file.write("""\
---
layout: post
title: "${postTitle}"
date: "${date.format(datetime_format)}"
author: 'u-ryo'
categories: []
comments: true
published: true
---
""")},
'create-page': { String location, String pageTitle ->
        def ext = new File(location).extension
        def file
        if (!ext) {
            file = new File(content_dir + location, 'index.markdown')
        } else {
            file = new File(content_dir, location)
        }
        file.parentFile.mkdirs()
        file.exists() || file.write("""---
layout: page
title: "${pageTitle}"
navigate: true
---
""")}]
