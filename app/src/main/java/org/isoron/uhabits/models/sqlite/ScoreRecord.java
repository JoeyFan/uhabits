/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.models.sqlite;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.isoron.uhabits.models.Habit;
import org.isoron.uhabits.models.Score;

/**
 * The SQLite database record corresponding to a Score.
 */
@Table(name = "Score")
public class ScoreRecord extends Model
{
    /**
     * Habit to which this score belongs to.
     */
    @Column(name = "habit")
    public HabitRecord habit;

    /**
     * Timestamp of the day to which this score applies. Time of day should be
     * midnight (UTC).
     */
    @Column(name = "timestamp")
    public Long timestamp;

    /**
     * Value of the score.
     */
    @Column(name = "score")
    public Integer score;

    /**
     * Constructs and returns a {@link Score} based on this record's data.
     *
     * @return a {@link Score} with this record's data
     */
    public Score toScore()
    {
        SQLiteHabitList habitList = SQLiteHabitList.getInstance();
        Habit h = habitList.getById(habit.getId());
        return new Score(h, timestamp, score);
    }
}