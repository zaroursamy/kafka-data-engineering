package model.source

case class Coordinates(coordinates: Seq[Double], `type`: String)
case class Contributor(id: Long, id_str: String, screen_name: String)
case class CurrentUserRetweet(id: Long, id_str: String)

case class Tweet(
    coordinates:               Option[Coordinates],
    created_at:                String,
    current_user_retweet:      Option[CurrentUserRetweet],
    entities:                  Option[Entities],
    favorite_count:            Option[Long],
    favorited:                 Option[Boolean],
    filter_level:              Option[String],
    id_str:                    String,
    in_reply_to_screen_name:   Option[String],
    in_reply_to_status_id_str: Option[String],
    in_reply_to_user_id_str:   Option[String],
    lang:                      Option[String],
    place:                     Option[Place],
    possibly_sensitive:        Option[Boolean],
    retweet_count:             Long,
    retweeted:                 Option[Boolean],
    retweeted_status:          Option[Tweet],
    source:                    String,
    text:                      String,
    user:                      UserFull,
    withheld_copyright:        Option[Boolean],
    withheld_in_countries:     Option[Seq[String]])

case class TweetFull(
    contributors:              Option[Seq[Contributor]],
    coordinates:               Option[Coordinates],
    created_at:                String,
    current_user_retweet:      Option[CurrentUserRetweet],
    entities:                  Option[Entities],
    favorite_count:            Option[Long],
    favorited:                 Option[Boolean],
    filter_level:              String,
    id:                        Long,
    id_str:                    String,
    in_reply_to_screen_name:   Option[String],
    in_reply_to_status_id:     Option[Long],
    in_reply_to_status_id_str: Option[String],
    in_reply_to_user_id:       Option[Long],
    in_reply_to_user_id_str:   Option[String],
    lang:                      Option[String],
    place:                     Option[Place],
    possibly_sensitive:        Option[Boolean],
    retweet_count:             Long,
    retweeted:                 Option[Boolean],
    retweeted_status:          Option[Tweet],
    source:                    String,
    text:                      String,
    truncated:                 Boolean,
    user:                      Option[UserFull],
    withheld_copyright:        Option[Boolean],
    withheld_in_countries:     Option[Seq[String]],
    withheld_scope:            Option[String])