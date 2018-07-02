package serde

import model.source.TweetFull
import org.scalatest.FunSuite

class TweetSerdeTest extends FunSuite {

  test("Serde test from json") {
    val str1 = "{\"created_at\":\"Tue Jun 12 17:00:23 +0000 2018\",\"id\":1006581995055398900,\"id_str\":\"1006581995055398912\",\"text\":\"RT @Ben__Harlan: #e3 #NintendoE3 \\nNever forget https://t.co/HkElG5mOL7\",\"source\":\"<a href=\\\"http://twitter.com/#!/download/ipad\\\" rel=\\\"nofollow\\\">Twitter for iPad</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":2547003477,\"id_str\":\"2547003477\",\"name\":\"Parker \uD83D\uDC96\uD83D\uDC99\uD83D\uDC9B\",\"screen_name\":\"missduckie\",\"location\":\"quarter fl - more personal\",\"url\":null,\"description\":\"fanacc - SOPE (noun) — 정호석 X 민윤기 ♡ 제이홉 X 슈가 — (171107 \uD83D\uDC98)\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":131,\"friends_count\":463,\"listed_count\":5,\"favourites_count\":2497,\"statuses_count\":31725,\"created_at\":\"Wed May 14 09:01:57 +0000 2014\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_image_url_https\":\"https://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"FAB81E\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/972209741605711872/vrcK6McA_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/972209741605711872/vrcK6McA_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/2547003477/1520627859\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Tue Jun 12 16:55:13 +0000 2018\",\"id\":1006580693986619400,\"id_str\":\"1006580693986619392\",\"text\":\"#e3 #NintendoE3 \\nNever forget https://t.co/HkElG5mOL7\",\"display_text_range\":[0,29],\"source\":\"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":13666862,\"id_str\":\"13666862\",\"name\":\"Ben\",\"screen_name\":\"Ben__Harlan\",\"location\":\"Hortaleza, Madrid, España\",\"url\":\"http://ben--harlan.tumblr.com/\",\"description\":\"Videogames, sometimes wrestling. WARNING: Dankness and bad english ahead con bastante español.\\n\\nbenjaminrosafernandez@gmail.com\",\"translator_type\":\"regular\",\"protected\":false,\"verified\":false,\"followers_count\":16098,\"friends_count\":771,\"listed_count\":81,\"favourites_count\":1476,\"statuses_count\":182925,\"created_at\":\"Tue Feb 19 10:55:04 +0000 2008\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"ABB8C2\",\"profile_background_image_url\":\"http://abs.twimg.com/images/themes/theme12/bg.gif\",\"profile_background_image_url_https\":\"https://abs.twimg.com/images/themes/theme12/bg.gif\",\"profile_background_tile\":true,\"profile_link_color\":\"1B95E0\",\"profile_sidebar_border_color\":\"F2E195\",\"profile_sidebar_fill_color\":\"FFF7CC\",\"profile_text_color\":\"0C3E53\",\"profile_use_background_image\":true,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/1003822089994895361/UNg8UP_z_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/1003822089994895361/UNg8UP_z_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/13666862/1526261675\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":1,\"retweet_count\":6,\"favorite_count\":7,\"entities\":{\"hashtags\":[{\"text\":\"e3\",\"indices\":[0,3]},{\"text\":\"NintendoE3\",\"indices\":[4,15]}],\"urls\":[],\"user_mentions\":[],\"symbols\":[],\"media\":[{\"id\":1006580664550993900,\"id_str\":\"1006580664550993920\",\"indices\":[30,53],\"media_url\":\"http://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"url\":\"https://t.co/HkElG5mOL7\",\"display_url\":\"pic.twitter.com/HkElG5mOL7\",\"expanded_url\":\"https://twitter.com/Ben__Harlan/status/1006580693986619392/photo/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"large\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"small\":{\"w\":600,\"h\":382,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1006580664550993900,\"id_str\":\"1006580664550993920\",\"indices\":[30,53],\"media_url\":\"http://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"url\":\"https://t.co/HkElG5mOL7\",\"display_url\":\"pic.twitter.com/HkElG5mOL7\",\"expanded_url\":\"https://twitter.com/Ben__Harlan/status/1006580693986619392/photo/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"large\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"small\":{\"w\":600,\"h\":382,\"resize\":\"fit\"}}}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\"},\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"e3\",\"indices\":[17,20]},{\"text\":\"NintendoE3\",\"indices\":[21,32]}],\"urls\":[],\"user_mentions\":[{\"screen_name\":\"Ben__Harlan\",\"name\":\"Ben\",\"id\":13666862,\"id_str\":\"13666862\",\"indices\":[3,15]}],\"symbols\":[],\"media\":[{\"id\":1006580664550993900,\"id_str\":\"1006580664550993920\",\"indices\":[47,70],\"media_url\":\"http://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"url\":\"https://t.co/HkElG5mOL7\",\"display_url\":\"pic.twitter.com/HkElG5mOL7\",\"expanded_url\":\"https://twitter.com/Ben__Harlan/status/1006580693986619392/photo/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"large\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"small\":{\"w\":600,\"h\":382,\"resize\":\"fit\"}},\"source_status_id\":1006580693986619400,\"source_status_id_str\":\"1006580693986619392\",\"source_user_id\":13666862,\"source_user_id_str\":\"13666862\"}]},\"extended_entities\":{\"media\":[{\"id\":1006580664550993900,\"id_str\":\"1006580664550993920\",\"indices\":[47,70],\"media_url\":\"http://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"media_url_https\":\"https://pbs.twimg.com/media/DfgXyARWsAA41bI.jpg\",\"url\":\"https://t.co/HkElG5mOL7\",\"display_url\":\"pic.twitter.com/HkElG5mOL7\",\"expanded_url\":\"https://twitter.com/Ben__Harlan/status/1006580693986619392/photo/1\",\"type\":\"photo\",\"sizes\":{\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"large\":{\"w\":600,\"h\":382,\"resize\":\"fit\"},\"small\":{\"w\":600,\"h\":382,\"resize\":\"fit\"}},\"source_status_id\":1006580693986619400,\"source_status_id_str\":\"1006580693986619392\",\"source_user_id\":13666862,\"source_user_id_str\":\"13666862\"}]},\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"filter_level\":\"low\",\"lang\":\"en\",\"timestamp_ms\":\"1528822823667\"}"
    val str2 = "{\"created_at\":\"Tue Jun 12 16:00:24 +0000 2018\",\"id\":1006566899541598200,\"id_str\":\"1006566899541598210\",\"text\":\"IT BEGINS!! #NintendoDirect\",\"source\":\"<a href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone</a>\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":782300925155237900,\"id_str\":\"782300925155237889\",\"name\":\"Nicholas C.3!!! - SMASH BROS MANIA\uD83C\uDFF3️\u200D\uD83C\uDF08\",\"screen_name\":\"nickisonlinet\",\"location\":\"[Discord: Nicholas C.#3576]\",\"url\":\"https://listography.com/nickisonlinet\",\"description\":\"artist-shitposter • video game-animation/anime addict • bad at rhyming\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":494,\"friends_count\":1229,\"listed_count\":4,\"favourites_count\":63943,\"statuses_count\":25798,\"created_at\":\"Sat Oct 01 19:27:29 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"lang\":\"en\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_image_url_https\":\"https://abs.twimg.com/images/themes/theme1/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"AC4185\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http://pbs.twimg.com/profile_images/1006299837019639809/mnsQF07e_normal.jpg\",\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/1006299837019639809/mnsQF07e_normal.jpg\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/782300925155237889/1528814363\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"NintendoDirect\",\"indices\":[12,27]}],\"urls\":[],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"en\",\"timestamp_ms\":\"1528819224616\"}"
    val str3 = "{\"created_at\":\"Tue Jun 12 16:08:16 +0000 2018\",\"id\":1006568879605407745,\"id_str\":\"1006568879605407745\",\"text\":\"#E32018 #NintendoDirect #NintendoE3 Mario Party sans ses v\\u00e9hicules! Enfin !\",\"source\":\"\\u003ca href=\\\"http:\\/\\/twitter.com\\\" rel=\\\"nofollow\\\"\\u003eTwitter Web Client\\u003c\\/a\\u003e\",\"truncated\":false,\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":770024717856145408,\"id_str\":\"770024717856145408\",\"name\":\"Beu\",\"screen_name\":\"Beu___\",\"location\":\"Nord-Pas-de-Calais, France\",\"url\":null,\"description\":\"Jeune prof angliciste. 28 ans, child at heart. Cultivateur de paradoxes. TV \\/ Music \\/ Series \\/ Boardgames \\/ Nintendo - et plein d'autres. Pop is life\\u270c\\ufe0f\\ud83c\\udf08\",\"translator_type\":\"none\",\"protected\":false,\"verified\":false,\"followers_count\":46,\"friends_count\":196,\"listed_count\":0,\"favourites_count\":3427,\"statuses_count\":2447,\"created_at\":\"Sun Aug 28 22:26:13 +0000 2016\",\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"lang\":\"fr\",\"contributors_enabled\":false,\"is_translator\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_link_color\":\"E22B31\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/871676690363273217\\/g1ZN5RAf_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/871676690363273217\\/g1ZN5RAf_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/770024717856145408\\/1515237982\",\"default_profile\":false,\"default_profile_image\":false,\"following\":null,\"follow_request_sent\":null,\"notifications\":null},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"is_quote_status\":false,\"quote_count\":0,\"reply_count\":0,\"retweet_count\":0,\"favorite_count\":0,\"entities\":{\"hashtags\":[{\"text\":\"E32018\",\"indices\":[0,7]},{\"text\":\"NintendoDirect\",\"indices\":[8,23]},{\"text\":\"NintendoE3\",\"indices\":[24,35]}],\"urls\":[],\"user_mentions\":[],\"symbols\":[]},\"favorited\":false,\"retweeted\":false,\"filter_level\":\"low\",\"lang\":\"fr\",\"timestamp_ms\":\"1528819696700\"}"

    val tweetsFull1: Option[TweetFull] = TweetSerde.fromJson(str1)
    val tweetsFull2: Option[TweetFull] = TweetSerde.fromJson(str2)
    val tweetsFull3: Option[TweetFull] = TweetSerde.fromJson(str3)

    assert(tweetsFull1.nonEmpty)
    assert(tweetsFull2.nonEmpty)
    assert(tweetsFull3.nonEmpty)
  }
}