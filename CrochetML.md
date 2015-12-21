# CrochetML Tags

Standard crochet pattern symbols can be found here: http://www.craftyarncouncil.com/crochet.html

| Tag | Description | Etc |
| --- | ----------- | --- |
| chain | Create a chain of as many stitches as specified | `<chain>15</chain>` |
| double-crochet | Create specified number of double crochet stitches | `<double-crochet>90</double-crochet>` |
| in-stitch | Do a stitch in specified stitch location | `<in-stitch location="4ch space"><double-crochet>10</double-crochet></in-stitch>` |
| | Also works with back loop | `<in-stitch location="fl><half-double-crochet>20</half-double-crochet>` |
| half-double-crochet | Create specified number of double crochet stitches | `<half-double-crochet>90</half-double-crochet>` |
| single crochet | Create specified number of single crochet stitches | `<single-crochet>90</single-crochet>` |
| slip-stitch | Create a slip stitch | `<in-stitch location="top chain"><slip-stitch /></in-stitch>`|
| stitch | A stitch type, not otherwise defined | `<stitch type="bobble" ref="bob">2</stitch>` |
| stitch-definition | Defines a non-standard stitch, include reference |  `<stitch-definition ref="bob">Five dc in 1 ch space...</stitch-definition>` |
