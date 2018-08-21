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

package de.tanktaler.insider.models.session.embedded.envelope;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import de.tanktaler.insider.models.session.embedded.SegmentTypedEnvelope;
import java.time.Instant;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public final class EnvelopeMapWay implements Envelope<EnvelopeMapWay.Payload> {
  private final String type;

  private final Instant timestamp;

  private final Integer version;

  @Embedded
  private final Payload payload;

  public EnvelopeMapWay(
    final String type, final Instant timestamp, final Integer version, final Payload payload
  ) {
    this.type = type;
    this.timestamp = timestamp;
    this.version = version;
    this.payload = payload;
  }

  public EnvelopeMapWay(
    final String type, final Instant timestamp, final Payload payload
  ) {
    this(type, timestamp, 1, payload);
  }

  public EnvelopeMapWay(final SegmentTypedEnvelope envelope) {
    this(envelope.type(), envelope.timestamp(), new Payload(envelope.payload()));
  }

  @Override
  public String type() {
    return this.type;
  }

  @Override
  public Instant timestamp() {
    return this.timestamp;
  }

  @Override
  public Integer version() {
    return this.version;
  }

  @Override
  public Payload payload() {
    return this.payload;
  }

  @Embedded
  public static final class Payload {
    private final Long id;
    private final Double speedMs;
    private final Double distanceM;
    private final Double durationS;
    private final Long timestamp;
    private final Long[] matches;

    public Payload(
      final Long id,
      final Double speedMs,
      final Double distanceM,
      final Double durationS,
      final Long timestamp,
      final Long[] matches
    ) {
      this.id = id;
      this.speedMs = speedMs;
      this.distanceM = distanceM;
      this.durationS = durationS;
      this.timestamp = timestamp;
      this.matches = matches;
    }

    public Payload(final BasicDBObject doc) {
      this(
        doc.getLong("id"),
        doc.getDouble("speedMs"),
        doc.getDouble("distanceM"),
        doc.getDouble("durationS"),
        doc.getLong("timestamp"),
        ((BasicDBList) doc.getOrDefault("matches", new BasicDBList())).toArray(new Long[0])
      );
    }

    public Long id() {
      return this.id;
    }

    public Double speedMs() {
      return this.speedMs;
    }

    public Double distanceM() {
      return this.distanceM;
    }

    public Double durationS() {
      return this.durationS;
    }

    public Long timestamp() {
      return this.timestamp;
    }

    public Long[] matches() {
      return this.matches;
    }
  }
}
