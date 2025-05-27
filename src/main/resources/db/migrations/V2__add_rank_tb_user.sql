-- V2: Migration that adds RANK column to teh table tb_user

ALTER TABLE tb_user
ADD COLUMN rank VARCHAR(255);
