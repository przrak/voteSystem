DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM dishes;
DELETE FROM menus;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001),
       ('ROLE_USER', 100001);

INSERT INTO restaurants (name)
VALUES ('Erarta'),       --100002
       ('Giotto'),       --100003
       ('Времена года'), --100004
       ('Maximilians'); --100005

INSERT INTO dishes (name, price, restaurant_id)
VALUES ('Салат с маринованной макрелью и редисом', 390, 100002),                          --100006
       ('Салат «Цезарь» с креветками', 390, 100002),                                      --100007
       ('Гребешки с морковным пюре, икрой и муссом из беконам', 680, 100002),             --100008
       ('Салат из утки c апельсинами', 650, 100002),                                      --100009
       ('Салат «Цезарь» с цыпленком', 390, 100002),                                       --100010
       ('Индейка гриль с рукколой и йогуртовым соусом', 580, 100002),                     --100011
       ('Куриная грудка со шпинатом, грибным муссом и грушей', 580, 100002),              --100012
       ('Филе-миньон с лжекартофелем, белыми грибами и трюфельным соусом', 950, 100002),  --100013
       ('Корейка ягненка с молодыми овощами ', 950, 100002),                              --100014
       ('Жареная треска с рагу из мидий и шпината', 780, 100002),                         --100015
       ('Запеченное в пергаменте филе судака с томатами и пряными травами', 780, 100002), --100016
       ('Паста карбонара', 480, 100002),                                                  --100017
       ('Сливочный суп с лососем', 480, 100002),                                          --100018
       ('Горячий борщ с ростбифом и салом ', 350, 100002),                                --100019
       ('Огуречный гаспачо с креветками', 530, 100002),                                   --100020
       ('Салат оливье', 450, 100003),                                                     --100021
       ('Салат с кальмаром', 850, 100003),                                                --100022
       ('Цезарь с креветками', 550, 100003),                                              --100023
       ('Салат греческий', 350, 100003),                                                  --100024
       ('Салат с печенью', 490, 100003),                                                  --100025
       ('Дорадо с лимоном и ароматными травами', 890, 100003),                            --100026
       ('Стейк тунца с перечным соусом', 530, 100003),                                    --100027
       ('Палтус с картофелем фри', 530, 100003),                                          --100028
       ('Цыпленок запеченый с помидорами черри и луком фри', 530, 100003),                --100029
       ('Голень барашка', 990, 100003),                                                   --100030
       ('Рёбра свиные', 650, 100003),                                                     --100031
       ('Уха', 490, 100003),                                                              --100032
       ('Страчателла', 330, 100003),                                                      --100033
       ('Борщ', 390, 100003),                                                             --100034
       ('Салат с семгой и микс салатом', 660, 100004),                                    --100035
       ('Салат с телятиной и микс салатом', 670, 100004),                                 --100036
       ('Салат «Нисуаз»', 530, 100004),                                                   --100037
       ('Салат «Оливье» с курицей', 530, 100004),                                         --100038
       ('Салат овощной «Греческий»', 570, 100004),                                        --100039
       ('Треска под цитрусовым маринадом', 850, 100004),                                  --100040
       ('Стейк из тунца в кунжуте', 980, 100004),                                         --100041
       ('Телятина на пюре из сельдерея с ягодным соусом', 750, 100004),                   --100042
       ('Цыпленок с ананасом и овощами в кисло-сладком соусе', 640, 100004),              --100043
       ('Котлеты куриные с картофельным пюре', 520, 100004),                              --100044
       ('Филе Сибаса с соусом Песто на свекольной «подушке»', 890, 100004),               --100045
       ('Окрошка мясная на квасе', 390, 100004),                                          --100046
       ('Борщ со сметаной', 410, 100004),                                                 --100047
       ('Бульон куриный с вермишелью, фрикадельками и перепелиным яйцом', 390, 100004),   --100048
       ('Салат с куриным филе', 490, 100005),                                             --100049
       ('Салат слоеный с лососем слабого посола', 440, 100005),                           --100050
       ('Салат с ростбифом', 650, 100005),                                                --100051
       ('Цезарь', 520, 100005),                                                           --100052
       ('Греческий салат', 410, 100005),                                                  --100053
       ('Вырезка говядины на гриле', 700, 100005),                                        --100054
       ('Филе-миньон с кукурузой гриль', 900, 100005),                                    --100055
       ('Телятина, тушеная в томатном соусе', 850, 100005),                               --100056
       ('Свиная вырезка', 800, 100005),                                                   --100057
       ('Рубленый бифштекс', 750, 100005),                                                --100058
       ('Скумбрия гриль', 600, 100005),                                                   --100059
       ('Суп с рыбой и морепродуктами', 350, 100005),                                     --100060
       ('Гороховый суп-пюре', 330, 100005),                                               --100061
       ('Суп с куриной ножкой', 400, 100005); --100062

INSERT INTO menus (dish_id, restaurant_id, date)
VALUES (100006, 100002, '2019-06-01 00:00:00'),
       (100011, 100002, '2019-06-01 00:00:00'),
       (100018, 100002, '2019-06-01 00:00:00'),
       (100007, 100002, '2019-06-02 00:00:00'),
       (100012, 100002, '2019-06-02 00:00:00'),
       (100019, 100002, '2019-06-02 00:00:00'),
       (100009, 100004, '2019-06-03 00:00:00'),
       (100015, 100004, '2019-06-03 00:00:00'),
       (100020, 100004, '2019-06-03 00:00:00'),
       (100010, 100005, '2019-06-04 00:00:00'),
       (100016, 100005, '2019-06-04 00:00:00'),
       (100018, 100005, '2019-06-04 00:00:00'),
       (100008, 100002, '2019-06-05 00:00:00'),
       (100017, 100002, '2019-06-05 00:00:00'),
       (100019, 100002, '2019-06-05 00:00:00'),
       (100021, 100003, '2019-06-01 00:00:00'),
       (100026, 100003, '2019-06-01 00:00:00'),
       (100033, 100003, '2019-06-01 00:00:00'),
       (100022, 100003, '2019-06-02 00:00:00'),
       (100027, 100003, '2019-06-02 00:00:00'),
       (100032, 100003, '2019-06-02 00:00:00'),
       (100023, 100003, '2019-06-03 00:00:00'),
       (100028, 100003, '2019-06-03 00:00:00'),
       (100034, 100003, '2019-06-03 00:00:00'),
       (100024, 100003, '2019-06-04 00:00:00'),
       (100029, 100003, '2019-06-04 00:00:00'),
       (100032, 100003, '2019-06-04 00:00:00'),
       (100025, 100003, '2019-06-05 00:00:00'),
       (100030, 100003, '2019-06-05 00:00:00'),
       (100033, 100003, '2019-06-05 00:00:00'),
       (100035, 100004, '2019-06-01 00:00:00'),
       (100040, 100004, '2019-06-01 00:00:00'),
       (100046, 100004, '2019-06-01 00:00:00'),
       (100036, 100004, '2019-06-02 00:00:00'),
       (100041, 100004, '2019-06-02 00:00:00'),
       (100047, 100004, '2019-06-02 00:00:00'),
       (100037, 100004, '2019-06-03 00:00:00'),
       (100042, 100004, '2019-06-03 00:00:00'),
       (100048, 100004, '2019-06-03 00:00:00'),
       (100038, 100004, '2019-06-04 00:00:00'),
       (100043, 100004, '2019-06-04 00:00:00'),
       (100047, 100004, '2019-06-04 00:00:00'),
       (100039, 100004, '2019-06-05 00:00:00'),
       (100044, 100004, '2019-06-05 00:00:00'),
       (100046, 100004, '2019-06-05 00:00:00'),
       (100049, 100005, '2019-06-01 00:00:00'),
       (100054, 100005, '2019-06-01 00:00:00'),
       (100060, 100005, '2019-06-01 00:00:00'),
       (100050, 100005, '2019-06-02 00:00:00'),
       (100055, 100005, '2019-06-02 00:00:00'),
       (100061, 100005, '2019-06-02 00:00:00'),
       (100051, 100005, '2019-06-03 00:00:00'),
       (100056, 100005, '2019-06-03 00:00:00'),
       (100062, 100005, '2019-06-03 00:00:00'),
       (100052, 100005, '2019-06-04 00:00:00'),
       (100057, 100005, '2019-06-04 00:00:00'),
       (100061, 100005, '2019-06-04 00:00:00'),
       (100053, 100005, '2019-06-05 00:00:00'),
       (100058, 100005, '2019-06-05 00:00:00'),
       (100060, 100005, '2019-06-05 00:00:00');