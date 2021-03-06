-- --------------------------------------------------------------------
-- Patch to add training and bonus stats columns to the character table
-- --------------------------------------------------------------------

ALTER TABLE characters
ADD `training_points` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_running` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_endurance` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_agility` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_ball_control` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_dribbling` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_stealing` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_tackling` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_heading` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_short_shots` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_long_shots` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_crossing` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_short_passes` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_long_passes` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_marking` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_goalkeeping` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_punching` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `training_defense` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_points` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_running` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_endurance` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_agility` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_ball_control` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_dribbling` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_stealing` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_tackling` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_heading` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_short_shots` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_long_shots` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_crossing` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_short_passes` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_long_passes` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_marking` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_goalkeeping` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_punching` smallint(6) unsigned NOT NULL DEFAULT '0',
ADD `bonus_defense` smallint(6) unsigned NOT NULL DEFAULT '0'