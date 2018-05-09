create table TOKEN (
   TOKEN_ID number,
   CAR_PLACE_ID number,
   PARKING_ID number,
   CAR_ID NUMBER ,
   amount NUMBER,
   ADD CONSTRAINT PK_TOKEN_ID PRIMARY KEY (TOKEN_ID);
);

create unique index tokenIdx1 on TOKEN(PARKING_ID, CAR_PLACE_ID, CAR_ID);

CREATE SEQUENCE token_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;



create table CAR (
   CAR_ID number,
   CAR_PLACE_ID number,
   ON_PARKING varchar2,
   CAR_NUMBER varchar2 ,
   ADD CONSTRAINT PK_CAR_ID PRIMARY KEY (CAR_ID);
);

create unique index carIdx1 on CAR(CAR_ID, CAR_NUMBER);

CREATE SEQUENCE car_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;


create table CAR_PLACE (
   CAR_PLACE_ID number,
   CAR_ID number,
   EMPTY varchar2 DEFAULT 'N',
   TIME_TO date,
   TIME_FROM date ,
   ADD CONSTRAINT PK_CAR_PLACEPRIMARY KEY (CAR_PLACE_ID);
);

CREATE SEQUENCE car_place_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

create table PARKING(
   PARK_ID number,
   CAR_PLACE_ID number,
);



create or replace package PKG_Parking IS

  function get_free_car_places() return sys_refcursor;

  function get_cars_on_parking_all() return sys_refcursor;

  function get_cars_on_parking_now() return sys_refcursor;

  function get_new_token(
      p_car_number VARCHAR2
    ) return sys_refcursor;

  procedure update_token(
      p_car_number in VARCHAR2,
      p_token_id in NUMBER
    );

end PKG_Parking;
/

create or replace package body PKG_Parking IS

  function get_free_car_places()
  return sys_refcursor IS
    vCursor sys_refcursor;
  BEGIN
    open vCursor FOR
       select
         *
       FROM
         CAR_PLACE
       where
          ON_PARKING = 'N';

  end get_free_car_places;

  function get_cars_on_parking_all()
  return sys_refcursor is
    vCursor sys_refcursor;
  BEGIN
    open vCursor FOR
      select
         car.*
       FROM
         CAR_PLACE carp, CAR car
       where
         car.CAR_PLACE_ID = carp.CAR_PLACE_ID;

  end get_cars_on_parking_all;
  /

  function get_cars_on_parking_now()
  return sys_refcursor is
    vCursor sys_refcursor;
  BEGIN
    open vCursor FOR
      select
         car.*
       FROM
         CAR_PLACE carp, CAR car
       where
         car.CAR_PLACE_ID = carp.CAR_PLACE_ID
         and car.ON_PARKING = 'Y';

  end get_cars_on_parking_now;
  /

  function set_new_token(
      p_car_number VARCHAR2
    ) return number is
    vNum number;
  BEGIN
    insert
      into CAR
        (CAR_ID, ON_PARKING, CAR_NUMBER)
      values
        (
           car_seq.NEXTVAL,
           'Y',
           p_car_number
        );

      insert
        into CAR_PLACE
          (CAR_PLACE_ID, CAR_ID, EMPTY, TIME_TO, TIME_FROM)
      select
        car_place_seq.NEXTVAL,
        (select car_id from CAR where car_number = p_car_number) car_id,
        'Y',
        sysdate,
        sysdate,
      from
        dual;

      insert
        into TOKEN
          (TOKEN_ID, CAR_PLACE_ID, PARKING_ID, CAR_ID, amount)
        select
          token_seq.nextval,
          (select car_place_id from CAR_PLACE where car_number = p_car_number) car_place_id,
          (select car_id from CAR where car_number = p_car_number) car_id,
          0 as AMOUNT
        from dual

        RETURNING TOKEN_ID INTO vNum;

        return vNum;

  end get_cars_on_parking_all;
  /

  function get_new_token(p_number number) return sys_refcursor
  is
    vResult sys_refcursor
  BEGIN
    open vResult for
      SELECT
        *
      from
        TOKEN
      where
        TOKEN_ID = p_number;
  end;

  procedure update_token(
      p_car_number in VARCHAR2,
      p_token_id in NUMBER
    ) IS
    vCar_Id number;
    vCar_place_id number;
  BEGIN

    BEGIN
     select
       CAR_ID, CAR_PLACE_ID
       into vCar_Id,vCar_place_id
      from
        TOKEN
      WHERE
        TOKEN_ID =p_token_id;

      EXCEPTION
        when no_data_found THEN
          vCar_Id := null;
          vCar_place_id := null;
    End;

    if vCar_Id <> null and vCar_place_id <> null then
    UPDATE
      CAR
    SET
      ON_PARKING = 'N',
    where
      CAR_ID = vCar_Id;

    UPDATE
      CAR_PLACE
    SET
      EMPTY = 'Y'

    end if;


  end get_cars_on_parking_all;
  /

end PKG_Parking;
/