/**
 * Copyright 2018 ThinxNet GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tanktaler.insider.models.session.embedded;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public final class SessionSegmentAttributes {
  private Double latitude;
  private Double longitude;
  private Double obdMaxRpm;
  private Integer geoSpeedKmH;
  private Integer gpsSpeedKmH;
  private Integer obdMaxSpeedKmH;

  public Double getLatitude() {
    return this.latitude;
  }

  public Double getLongitude() {
    return this.longitude;
  }

  public Double obdMaxRpm() {
    return this.obdMaxRpm;
  }

  public Integer getGeoSpeedKmH() {
    return this.geoSpeedKmH;
  }

  public Integer getGpsSpeedKmH() {
    return this.gpsSpeedKmH;
  }

  public Integer obdMaxSpeedKmH() {
    return this.obdMaxSpeedKmH;
  }
}