package model.source

case class PlaceCoordinates(
    coordinates: Seq[Seq[Seq[Float]]],
    `type`:      String)

case class Place(
    country:      String,
    country_code: String,
    full_name:    String,
    id:           String,
    name:         String,
    place_type:   String,
    url:          String)