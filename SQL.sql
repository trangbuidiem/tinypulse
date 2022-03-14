SELECT count(*) Result FROM `suggestions` s
INNER JOIN (
  SELECT source_id FROM `comments` c
  WHERE source_type='Suggestion'
  GROUP BY source_id
) c ON s.id = c.source_id
WHERE s.submitted_at BETWEEN '2020-01-01 00:00:01' AND '2020-03-31 23:59:59'