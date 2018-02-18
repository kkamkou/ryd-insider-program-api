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

package de.tanktaler.insider.model.thing;

import de.tanktaler.insider.model.user.User;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

@Entity(value = "things", noClassnameStored = true)
@Indexes(
  @Index(value = "account", fields = @Field("account"))
)
@JsonApiResource(type = "things")
public final class Thing {
  @Id
  @JsonApiId
  private ObjectId id;

  private String account;

  private String nickName;

  private ThingYmme ymme;

  @JsonApiRelation
  @Reference
  private List<User> users;

  public ObjectId getId() {
    return id;
  }

  public ThingYmme getYmme() {
    return ymme;
  }

  public String getAccount() {
    return account;
  }

  public String getNickName() {
    return nickName;
  }
}
