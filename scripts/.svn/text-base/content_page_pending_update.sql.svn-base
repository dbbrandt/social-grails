ALTER TABLE esmzone.content_page ADD (status VARCHAR(255));
ALTER TABLE esmzone.content_section ADD (status VARCHAR(255));

update content_page set status = "ACTIVE";
update content_section set status = "ACTIVE";

drop index `view` on `content_page`;

ALTER TABLE esmzone.system_config ADD (show_pending_content BIT);
