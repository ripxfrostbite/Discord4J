/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J. If not, see <http://www.gnu.org/licenses/>.
 */

package discord4j.gateway;

import java.util.Objects;

public class ShardInfo {

    private final int index;
    private final int count;

    public ShardInfo(int index, int count) {
        this.index = index;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShardInfo shardInfo = (ShardInfo) o;
        return index == shardInfo.index &&
                count == shardInfo.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, count);
    }

    public String format() {
        return index + "," + count;
    }

    @Override
    public String toString() {
        return "ShardInfo{" +
                "index=" + index +
                ", count=" + count +
                '}';
    }
}
