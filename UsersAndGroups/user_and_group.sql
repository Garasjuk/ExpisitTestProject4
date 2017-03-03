-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Мар 03 2017 г., 13:44
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `user_and_group`
--

-- --------------------------------------------------------

--
-- Структура таблицы `groupp`
--

CREATE TABLE IF NOT EXISTS `groupp` (
  `id_group` int(11) NOT NULL AUTO_INCREMENT,
  `name_group` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_group`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Дамп данных таблицы `groupp`
--

INSERT INTO `groupp` (`id_group`, `name_group`) VALUES
(1, 'Nature'),
(2, 'Car'),
(3, 'Food'),
(4, 'Sport'),
(5, 'Sweem'),
(6, 'Feeshing'),
(7, 'Shopping');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login_user` varchar(30) DEFAULT NULL,
  `pass_user` varchar(50) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `date_birthday` date DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id_user`, `login_user`, `pass_user`, `last_name`, `first_name`, `date_birthday`) VALUES
(1, 'User1', '123', 'Christophe', 'Verre', '2000-08-21'),
(2, 'User2', '123', 'Mimi', 'Tam', '2000-01-13'),
(3, 'User3', '123', 'Pat', 'Patison', '1999-08-11'),
(8, 'User5', 'qwe', 'qwe', 'qwe', '2001-03-01'),
(9, 'User6', '123', 'qw', 'qwq', '2000-12-12'),
(10, 'User7', '123', 'qwe', 'asd', '2013-02-06'),
(11, 'User8', '123', 'qwe', 'aqsd', '2017-02-15'),
(12, 'User9', '123', 'Mark', 'Tog', '2007-08-12'),
(13, 'User10', '321', 'rfv', 'tgb', '2010-01-25'),
(14, 'User11', '444', 'qwe', 'edd', '2008-02-06'),
(15, 'User12', '555', 'ttt', 'rrr', '2004-06-16');

-- --------------------------------------------------------

--
-- Структура таблицы `userandgroup`
--

CREATE TABLE IF NOT EXISTS `userandgroup` (
  `id_userAndGroup` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_group` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_userAndGroup`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Дамп данных таблицы `userandgroup`
--

INSERT INTO `userandgroup` (`id_userAndGroup`, `id_user`, `id_group`) VALUES
(3, 1, 3),
(4, 2, 1),
(5, 2, 2),
(7, 3, 4),
(8, 3, 3),
(12, 9, 2),
(21, 9, 4),
(26, 3, 5),
(27, 9, 5),
(28, 2, 5),
(29, 9, 3),
(33, 2, 4),
(34, 1, 5),
(39, 8, 4),
(40, 8, 3),
(41, 11, 4),
(42, 11, 3),
(43, 11, 1),
(44, 9, 6),
(46, 11, 6),
(47, 10, 6),
(48, 12, 4),
(49, 12, 3),
(50, 12, 2),
(51, 13, 5),
(52, 13, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
